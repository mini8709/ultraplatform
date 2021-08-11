package com.tmax.ultraplatform.domain.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 552898642L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBook book = new QBook("book");

    public final QProduct _super;

    public final StringPath author = createString("author");

    //inherited
    public final ListPath<com.tmax.ultraplatform.domain.Basket, com.tmax.ultraplatform.domain.QBasket> basketList;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath imageURL;

    //inherited
    public final StringPath info;

    public final StringPath isbn = createString("isbn");

    // inherited
    public final com.tmax.ultraplatform.domain.QMember member;

    //inherited
    public final StringPath name;

    //inherited
    public final ListPath<com.tmax.ultraplatform.domain.OrdersProduct, com.tmax.ultraplatform.domain.QOrdersProduct> ordersProductList;

    //inherited
    public final NumberPath<Integer> price;

    //inherited
    public final ListPath<com.tmax.ultraplatform.domain.ProductCategory, com.tmax.ultraplatform.domain.QProductCategory> productCategoryList;

    public final StringPath sort = createString("sort");

    //inherited
    public final NumberPath<Integer> stockQuantity;

    public QBook(String variable) {
        this(Book.class, forVariable(variable), INITS);
    }

    public QBook(Path<? extends Book> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBook(PathMetadata metadata, PathInits inits) {
        this(Book.class, metadata, inits);
    }

    public QBook(Class<? extends Book> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QProduct(type, metadata, inits);
        this.basketList = _super.basketList;
        this.id = _super.id;
        this.imageURL = _super.imageURL;
        this.info = _super.info;
        this.member = _super.member;
        this.name = _super.name;
        this.ordersProductList = _super.ordersProductList;
        this.price = _super.price;
        this.productCategoryList = _super.productCategoryList;
        this.stockQuantity = _super.stockQuantity;
    }

}

