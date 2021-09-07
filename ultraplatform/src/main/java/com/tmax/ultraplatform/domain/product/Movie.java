package com.tmax.ultraplatform.domain.product;

import com.tmax.ultraplatform.domain.Category;
import com.tmax.ultraplatform.domain.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("P_MOVIE")
@Getter
public class Movie extends Product{
    private String director;
    private String genre;

    @Builder
    public Movie createMovie(Member member, String name, int stockQuantity, int price, String info, String imageURL, List<Category> categories, String director, String genre){
        Movie movie = new Movie();
        movie.setMember(member);
        movie.setCommonFields(name, stockQuantity, price, info, imageURL);
        movie.setBookFields(director, genre);
        movie.setProductCategoryMapping(categories);
        return movie;
    }

    public void setBookFields( String director, String genre) {
        this.director = director;
        this.genre = genre;
    }
}
