package com.tmax.ultraplatform.domain.product;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P_MOVIE")
@Getter
public class Movie extends Product{

    private String director;
    private String genre;
}
