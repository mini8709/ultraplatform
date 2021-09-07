package com.tmax.ultraplatform.domain.product;

import com.tmax.ultraplatform.domain.Category;
import com.tmax.ultraplatform.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("P_BOOK")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Product{

    private String author;
    private String sort; //도서 종류
    private String isbn;

    @Builder(builderMethodName = "bookBuilder")
    public static Book createBook(Member member, String name, int stockQuantity, int price, String info, String imageURL, List<Category> categories, String author, String sort, String isbn){
        Book book = new Book();
        book.setMember(member);
        book.setCommonFields(name, stockQuantity, price, info, imageURL);
        book.setBookFields(author, sort, isbn);
        book.setProductCategoryMapping(categories);
        return book;
    }

    public void setBookFields(String author, String sort, String isbn) {
        this.author = author;
        this.sort = sort;
        this.isbn = isbn;
    }

}
