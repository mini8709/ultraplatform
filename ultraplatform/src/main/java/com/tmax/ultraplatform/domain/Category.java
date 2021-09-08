package com.tmax.ultraplatform.domain;

import com.tmax.ultraplatform.domain.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 코드성 테이블
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    // 이름 생성자
    public Category(String name) {
        this.name = name;
    }

    // 부모 카테고리 설정
    public void setParentCategory(Category parent){
        if(this.parentCategory!=null){
            this.parentCategory.getChildCategoryList().removeIf(c->c.getId().equals(this.getId()));
        }
        this.parentCategory = parent;
        parent.childCategoryList.add(this);
    }


}
