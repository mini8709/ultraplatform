package com.tmax.ultraplatform.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tmax.ultraplatform.domain.*;
import com.tmax.ultraplatform.exception.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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


    //연관관계 메서드
    protected void setMember(Member member){
        this.member = member;
        member.getProductList().add(this);
    }

    protected void setProductCategoryMapping(List<Category> categories){
        List<ProductCategory> productCategories= categories.stream()
                                                        .map(c->new ProductCategory(this,c))
                                                        .collect(Collectors.toList());
        this.productCategoryList.addAll(productCategories);
        productCategories.stream().forEach(pc->pc.getCategory().getProductCategoryList().add(pc));
    }

    //공통 필드 세팅
    public void setCommonFields(String name, int stockQuantity, int price, String info, String imageURL){
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.info = info;
        this.imageURL = imageURL;
    }



    //비즈니스 로직

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


    public void addStock(int stockQuantity){
        this.stockQuantity += stockQuantity;
    }

}
