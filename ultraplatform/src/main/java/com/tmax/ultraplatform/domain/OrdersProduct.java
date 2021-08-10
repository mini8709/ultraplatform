package com.tmax.ultraplatform.domain;

import com.tmax.ultraplatform.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrdersProduct {

    @Id
    @GeneratedValue
    @Column(name = "orders_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    private int count;
    private int price;
}
