package com.tmax.ultraplatform.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1852721692L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final QAddress address;

    public final ListPath<Basket, QBasket> basketList = this.<Basket, QBasket>createList("basketList", Basket.class, QBasket.class, PathInits.DIRECT2);

    public final ListPath<Coupon, QCoupon> couponList = this.<Coupon, QCoupon>createList("couponList", Coupon.class, QCoupon.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> money = createNumber("money", Integer.class);

    public final StringPath name = createString("name");

    public final ListPath<Orders, QOrders> ordersList = this.<Orders, QOrders>createList("ordersList", Orders.class, QOrders.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final ListPath<com.tmax.ultraplatform.domain.product.Product, com.tmax.ultraplatform.domain.product.QProduct> productList = this.<com.tmax.ultraplatform.domain.product.Product, com.tmax.ultraplatform.domain.product.QProduct>createList("productList", com.tmax.ultraplatform.domain.product.Product.class, com.tmax.ultraplatform.domain.product.QProduct.class, PathInits.DIRECT2);

    public final EnumPath<MemberType> type = createEnum("type", MemberType.class);

    public final StringPath userId = createString("userId");

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
    }

}

