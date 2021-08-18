package com.tmax.ultraplatform.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.exception.NotEnoughMoneyException;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userId;
    private String password;
    private String name;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    private int money;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Coupon> couponList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Basket> basketList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Product> productList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();


    // ** 비즈니스 로직 ** //

    /*
     * 잔액 증가
     */
    public void addMoney(int money){
        this.money += money;
    }

    /*
     * 잔액 감소
     */
    public void minusMoney(int money){
        int restMoney = this.money - money;

        if(restMoney < 0){
            throw new NotEnoughMoneyException("잔액이 부족합니다.");
        }

        this.money = restMoney;
    }

}
