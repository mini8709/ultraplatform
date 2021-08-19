package com.tmax.ultraplatform.service.queryservice;

import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.ProductCategory;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductQueryService {
    private final EntityManager em;
    private final ProductRepository productRepository;
    //전체 목록 조회
    public Result findProducts() {
        return new Result(productRepository.findAll());
    }
    //ID로 프로덕트 조회. id 없을 시 exception발생
    public  Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such product"));
    }
    //카테고리 목록을 포함하여 모든 상품 조회
    public Result findAllWithCategories(int offset, int limit){
        List<Product> products = productRepository.findAllWithCategory(offset,limit);
        List<ProductDto> result = products.stream().map(ProductDto::new).collect(toList());
        return new Result(result);
    }

    // 여러 상품 id로 상품들 조회
    public Result findByIds(List<Long> ids){
        List<Product> products = productRepository.findByIds(ids);
        List<ProductDto> result = products.stream().map(ProductDto::new).collect(toList());
        return new Result(result);
    }
    // 특정 최하위 카테고리에 해당하는 상품들 조회
    public Result findByCategory(Long categoryId,int offset, int limit){
        List<Product> products = productRepository.findByCategory(categoryId, offset,limit);
        List<ProductDto> result = products.stream().map(ProductDto::new).collect(toList());
        return new Result(result);
    }

    @Data
    @AllArgsConstructor
    static class ProductDto{
        private Long id;
        private Member member;
        private String name;
        private int stockQuantity;
        private int price;
        private String info;
        private String imageURL;
        private List<String> categories;

        public ProductDto(Product product){
            id = product.getId();
            member = product.getMember();
            name = product.getName();
            stockQuantity = product.getStockQuantity();
            price = product.getPrice();
            info = product.getInfo();
            imageURL = product.getImageURL();
            categories=product.getProductCategoryList().stream().map(p->p.getCategory().getName()).collect(toList());
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

}
