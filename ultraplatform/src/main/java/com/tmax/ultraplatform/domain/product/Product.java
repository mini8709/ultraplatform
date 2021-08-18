package com.tmax.ultraplatform.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tmax.ultraplatform.domain.Basket;
import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.OrdersProduct;
import com.tmax.ultraplatform.domain.ProductCategory;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn
@Getter
public abstract class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    /*
     * 판매자 ID
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Basket> basketList = new ArrayList<>();

    private String name;
    private int stockQuantity;
    private int price;
    private String info;
    private String imageURL;

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategoryList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrdersProduct> ordersProductList = new ArrayList<>();


    /*
    *  비즈니스 로직
    * */
    public void addStock(int stockQuantity){
        this.stockQuantity += stockQuantity;}

    public void updateProduct(Product product){
        this.name = product.name;
        this.stockQuantity = product.stockQuantity;
        this.price = product.price;
        this.info = product.info;
        this.imageURL = product.imageURL;
    }


}
