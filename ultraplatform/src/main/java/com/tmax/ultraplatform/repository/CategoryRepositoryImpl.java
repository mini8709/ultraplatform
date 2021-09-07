package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.Category;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepositoryCustom{

    @Override
    public List<Category> findAllWithChild() {
        return null;
    }

    @Override
    public List<Category> findLeafCategories() {
        return null;
    }

    @Override
    public List<Category> findByParent(Long parentId) {
        return null;
    }

    @Override
    public Boolean isLeaf(Long id) {
        return null;
    }
}
