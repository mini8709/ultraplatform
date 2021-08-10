package com.tmax.ultraplatform.domain.product;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P_BOOK")
@Getter
public class Book extends Product{

    private String author;
    private String sort; //도서 종류
    private String isbn;
}
