package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.product.Product;

import java.util.List;


//사용자 정의 repository를 사용하기 위한 interface
public interface ProductRepositoryCustom {
    List<Product> findAllWithCategory(int offset, int limit);

    List<Product> findByIds(List<Long> ids);

    List<Product> findByCategory(Long categoryId,int offset, int limit);
}
