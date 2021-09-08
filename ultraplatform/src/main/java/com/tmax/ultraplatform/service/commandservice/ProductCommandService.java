package com.tmax.ultraplatform.service.commandservice;

import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductRepository productRepository;
   //Insert , product-category insert 추가 필요
    public void addProduct(Product product){
        productRepository.save(product);
    }

    //Update, product-category update 추가 필요
    public void updateProduct(Long id,Product param){
    }
}
