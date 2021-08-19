package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

//spring data jpa repo + querydsl custom repo
public interface ProductRepository extends JpaRepository<Product,Long>, ProductRepositoryCustom {
}
