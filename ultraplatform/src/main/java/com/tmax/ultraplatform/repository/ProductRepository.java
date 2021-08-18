package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
