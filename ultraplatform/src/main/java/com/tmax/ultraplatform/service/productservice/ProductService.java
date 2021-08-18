package com.tmax.ultraplatform.service.productservice;

import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Long id,Product param){
        Product product = productRepository.getById(id);
        product.updateProduct(param);
    }
}
