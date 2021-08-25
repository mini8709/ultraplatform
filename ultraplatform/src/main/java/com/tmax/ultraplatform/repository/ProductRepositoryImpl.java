package com.tmax.ultraplatform.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tmax.ultraplatform.domain.QProductCategory;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.domain.product.QProduct;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

//사용자 정의 리포지토리 구현체
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory query = new JPAQueryFactory(em);
    private final QProduct product = QProduct.product;
    private final QProductCategory productCategory = QProductCategory.productCategory;

    @Override
    public List<Product> findAllWithCategory(int offset, int limit){
        return query.select(product)
                .from(product)
                .join(product.productCategoryList, productCategory)
                .limit(limit)
                .offset(offset)
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
        return query.select(product)
                .from(product)
                .join(product.productCategoryList, productCategory)
                .where(product.id.in(ids))
                .fetch();
    }

    @Override
    public List<Product> findByCategory(Long categoryId,int offset, int limit) {
        return query.select(product)
                .from(product)
                .leftJoin(product.productCategoryList, productCategory)
                .on(productCategory.category.id.eq(categoryId))
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}
