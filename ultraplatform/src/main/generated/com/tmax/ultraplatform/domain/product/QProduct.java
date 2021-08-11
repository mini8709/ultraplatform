package com.tmax.ultraplatform.domain.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -170192154L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final ListPath<com.tmax.ultraplatform.domain.Basket, com.tmax.ultraplatform.domain.QBasket> basketList = this.<com.tmax.ultraplatform.domain.Basket, com.tmax.ultraplatform.domain.QBasket>createList("basketList", com.tmax.ultraplatform.domain.Basket.class, com.tmax.ultraplatform.domain.QBasket.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageURL = createString("imageURL");

    public final StringPath info = createString("info");

    public final com.tmax.ultraplatform.domain.QMember member;

    public final StringPath name = createString("name");

    public final ListPath<com.tmax.ultraplatform.domain.OrdersProduct, com.tmax.ultraplatform.domain.QOrdersProduct> ordersProductList = this.<com.tmax.ultraplatform.domain.OrdersProduct, com.tmax.ultraplatform.domain.QOrdersProduct>createList("ordersProductList", com.tmax.ultraplatform.domain.OrdersProduct.class, com.tmax.ultraplatform.domain.QOrdersProduct.class, PathInits.DIRECT2);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final ListPath<com.tmax.ultraplatform.domain.ProductCategory, com.tmax.ultraplatform.domain.QProductCategory> productCategoryList = this.<com.tmax.ultraplatform.domain.ProductCategory, com.tmax.ultraplatform.domain.QProductCategory>createList("productCategoryList", com.tmax.ultraplatform.domain.ProductCategory.class, com.tmax.ultraplatform.domain.QProductCategory.class, PathInits.DIRECT2);

    public final NumberPath<Integer> stockQuantity = createNumber("stockQuantity", Integer.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.tmax.ultraplatform.domain.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

