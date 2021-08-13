package com.tmax.ultraplatform.service.productservice;

import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findProducts() {
        return productRepository.findAll();}

    public List<Product> findProductsByCategory(String category) {
        return productRepository.findByCategory(category);}

}
