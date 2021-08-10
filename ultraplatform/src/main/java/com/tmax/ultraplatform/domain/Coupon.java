package com.tmax.ultraplatform.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Coupon {

    @Id @GeneratedValue
    @Column(name = "coupon_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //FK
    private Member member;

    private String name;

    //퍼센트 할인쿠폰 (10% 할인 같은거)
    private int percent;
    //가격 할인쿠폰 (천원 할인같은거)
    private int value;
    //쿠폰 기한
    private LocalDateTime dueDate;

}
