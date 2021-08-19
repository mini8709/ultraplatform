package com.tmax.ultraplatform.domain;

import com.tmax.ultraplatform.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrdersProduct {

    @Id
    @GeneratedValue
    @Column(name = "orders_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    private int count;
    private int price;

    //생성 메서드
    public static OrdersProduct createOrdersProduct(Product product, int price, int count){
        OrdersProduct ordersProduct = new OrdersProduct();

        ordersProduct.setProduct(product);
        ordersProduct.setPrice(price);
        ordersProduct.setCount(count);

        product.minusStock(count);

        return ordersProduct;
    }
}
