package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
