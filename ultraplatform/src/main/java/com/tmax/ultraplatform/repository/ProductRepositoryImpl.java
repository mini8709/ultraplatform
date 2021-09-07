package com.tmax.ultraplatform.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tmax.ultraplatform.domain.QProductCategory;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.domain.product.QProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static com.tmax.ultraplatform.domain.QProductCategory.*;
import static com.tmax.ultraplatform.domain.product.QProduct.*;

//사용자 정의 리포지토리 구현체

public class ProductRepositoryImpl implements ProductRepositoryCustom
{

    private final JPAQueryFactory query;
    public ProductRepositoryImpl(EntityManager em){
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> findAllWithCategory(Pageable pageable){
        return query.select(product)
                .from(product).distinct()
                .join(product.productCategoryList, productCategory).fetchJoin()
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
//        return em.createQuery(
//                "select p from Product p" +
//                        " join fetch p.productCategoryList pc", Product.class)
//                .setFirstResult(offset)
//                .setMaxResults(limit)
//                .getResultList();
    }

    @Override
    public List<Product> findByIds(List<Long> ids) {
        QProduct product = QProduct.product;
        QProductCategory productCategory = QProductCategory.productCategory;

        return query.select(product)
                .from(product).distinct()
                .join(product.productCategoryList, productCategory).fetchJoin()
                .where(product.id.in(ids))
                .fetch();
    }

    @Override
    public List<Product> findByCategory(Long categoryId, Pageable pageable) {
        QProduct product = QProduct.product;
        QProductCategory productCategory = QProductCategory.productCategory;

        return query.select(product)
                .from(product).distinct()
                .innerJoin(product.productCategoryList, productCategory)
                .on(productCategory.category.id.eq(categoryId))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }
}
