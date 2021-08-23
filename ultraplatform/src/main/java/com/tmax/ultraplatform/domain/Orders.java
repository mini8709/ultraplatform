package com.tmax.ultraplatform.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id @GeneratedValue
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrdersProduct> ordersProductList = new ArrayList<>();


    //연관관계 메서드
    public void addOrdersProduct(OrdersProduct ordersProduct){
        this.ordersProductList.add(ordersProduct);
        ordersProduct.setOrders(this);
    }

    //생성 메서드
    public static Orders createOrders(Member member, List<OrdersProduct> ordersProducts){
        Orders orders = new Orders();
        orders.setMember(member);

        for(OrdersProduct op : ordersProducts){
            orders.addOrdersProduct(op);
        }
        orders.setStatus(OrderStatus.PREPARING);
        orders.setOrderDate(LocalDateTime.now());

        return orders;
    }

}
