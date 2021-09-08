package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
