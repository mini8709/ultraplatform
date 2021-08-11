package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
