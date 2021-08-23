package com.tmax.ultraplatform.service.commandservice;

import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.Orders;
import com.tmax.ultraplatform.domain.OrdersProduct;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.repository.MemberRepository;
import com.tmax.ultraplatform.repository.OrdersRepository;
import com.tmax.ultraplatform.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersCommandService {

    private final OrdersRepository ordersRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;


    /*
     * 주문
     */
    @Transactional
    public void order(Long memberId, List<OrdersProductVO> ordersProductVOS){

        Member findMember = memberRepository.findOne(memberId);

        List<OrdersProduct> ordersProductList = new ArrayList<>();

        for(OrdersProductVO vo : ordersProductVOS){
            Optional<Product> product = productRepository.findById(vo.getProductId());
            product.ifPresent(findProduct-> {
                OrdersProduct tmpOrdersProduct = OrdersProduct.createOrdersProduct(findProduct, findProduct.getPrice(), vo.getCount());
                ordersProductList.add(tmpOrdersProduct);
            });
        }

        Orders orders = Orders.createOrders(findMember, ordersProductList);

        ordersRepository.save(orders);

    }

}
@Getter
final class OrdersProductVO{

    private Long productId;
    private int count;

    public OrdersProductVO(Long id, int count){
        this.productId = id;
        this.count = count;
    }
}
