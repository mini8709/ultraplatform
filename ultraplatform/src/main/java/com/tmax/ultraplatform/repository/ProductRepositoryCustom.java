package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.product.Product;
import org.springframework.data.domain.Pageable;


import java.util.List;


//사용자 정의 repository를 사용하기 위한 interface
public interface ProductRepositoryCustom {
    List<Product> findAllWithCategory(Pageable pageable);

    List<Product> findByIds(List<Long> ids);

    List<Product> findByCategory(Long categoryId, Pageable pageable);
}
