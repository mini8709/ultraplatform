package com.tmax.ultraplatform.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tmax.ultraplatform.domain.Basket;
import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.OrdersProduct;
import com.tmax.ultraplatform.domain.ProductCategory;
import com.tmax.ultraplatform.exception.NotEnoughStockException;
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

    //비즈니스 로직

    /*
     * 재고 수량 증가
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /*
     * 재고 수량 감소
     */
    public void minusStock(int quantity){

        int restStock = this.stockQuantity - quantity;

        if(restStock < 0){
            throw new NotEnoughStockException("재고 수량이 부족합니다.");
        }
        this.stockQuantity = restStock;
    }

    public void updateProduct(Product product){
        this.name = product.name;
        this.stockQuantity = product.stockQuantity;
        this.price = product.price;
        this.info = product.info;
        this.imageURL = product.imageURL;
    }

}
