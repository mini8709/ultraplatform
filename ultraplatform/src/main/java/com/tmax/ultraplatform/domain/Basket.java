package com.tmax.ultraplatform.domain;

import lombok.Getter;

import javax.persistence.*;

/*
 * 장바구니는 결국 Member와 Product의 다대다 관계 사이 맵핑해주는 테이블
 */

@Entity
@Getter
public class Basket {

    @Id @GeneratedValue
    @Column(name = "basket_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int count;
}
