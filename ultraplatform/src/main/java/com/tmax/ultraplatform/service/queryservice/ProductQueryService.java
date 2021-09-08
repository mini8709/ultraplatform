package com.tmax.ultraplatform.service.queryservice;

import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.ProductCategory;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductQueryService {
    private final EntityManager em;
    private final ProductRepository productRepository;

    //전체 목록 조회
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    //ID로 프로덕트 조회. id 없을 시 exception발생
    public  Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such product"));
    }

    //카테고리 목록을 포함하여 모든 상품 조회
    public List<ProductDto> findAllWithCategories(Pageable pageable){
        List<Product> products = productRepository.findAllWithCategory(pageable);
        return products.stream().map(ProductDto::new).collect(toList());
    }

    // 여러 상품 id로 상품들 조회
    public List<ProductDto> findByIds(List<Long> ids){
        List<Product> products = productRepository.findByIds(ids);
        return products.stream().map(ProductDto::new).collect(toList());
    }
    // 특정 최하위 카테고리에 해당하는 상품들 조회
    public List<ProductDto> findByCategory(Long categoryId, Pageable pageable){
        List<Product> products = productRepository.findByCategory(categoryId, pageable);
        return products.stream().map(ProductDto::new).collect(toList());
    }

    @Data
    @AllArgsConstructor
    public class ProductDto{
        private Long id;
        private Member member;
        private String name;
        private int stockQuantity;
        private int price;
        private String info;
        private String imageURL;
        private Map<Long, String> categories = new HashMap<>();

        public ProductDto(Product product){
            id = product.getId();
            member = product.getMember();
            name = product.getName();
            stockQuantity = product.getStockQuantity();
            price = product.getPrice();
            info = product.getInfo();
            imageURL = product.getImageURL();
            product.getProductCategoryList().stream().forEach(p -> categories.put(p.getCategory().getId(), p.getCategory().getName()));
        }
    }



}
