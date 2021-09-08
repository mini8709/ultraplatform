package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.Category;

import java.util.List;

public interface CategoryRepositoryCustom {

    List<Category> findAllWithChild();

    List<Category> findLeafCategories();

    List<Category> findByParent(Long parentId);

    Boolean isLeaf(Long id);
}
