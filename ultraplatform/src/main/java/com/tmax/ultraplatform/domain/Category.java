package com.tmax.ultraplatform.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 코드성 테이블
 */
@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> childCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategoryList = new ArrayList<>();

}
