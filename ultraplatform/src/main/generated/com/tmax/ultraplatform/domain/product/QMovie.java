package com.tmax.ultraplatform.domain.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = -29845785L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovie movie = new QMovie("movie");

    public final QProduct _super;

    //inherited
    public final ListPath<com.tmax.ultraplatform.domain.Basket, com.tmax.ultraplatform.domain.QBasket> basketList;

    public final StringPath director = createString("director");

    public final StringPath genre = createString("genre");

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath imageURL;

    //inherited
    public final StringPath info;

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

    //inherited
    public final NumberPath<Integer> stockQuantity;

    public QMovie(String variable) {
        this(Movie.class, forVariable(variable), INITS);
    }

    public QMovie(Path<? extends Movie> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovie(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovie(PathMetadata metadata, PathInits inits) {
        this(Movie.class, metadata, inits);
    }

    public QMovie(Class<? extends Movie> type, PathMetadata metadata, PathInits inits) {
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

