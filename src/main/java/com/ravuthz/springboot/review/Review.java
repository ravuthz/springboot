package com.ravuthz.springboot.review;

import com.ravuthz.springboot.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:56 PM
 * Email : ravuthz@gmail.com
 */

@Entity
public class Review extends BaseEntity {
    private int rating;
    private String description;

    public Review() {
        super();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
