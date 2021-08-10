package com.tmax.ultraplatform.domain;

import com.tmax.ultraplatform.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProductCategory {

    @Id
    @GeneratedValue
    @Column(name = "product_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
