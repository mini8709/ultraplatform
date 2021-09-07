package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>, CategoryRepositoryCustom  {
}
