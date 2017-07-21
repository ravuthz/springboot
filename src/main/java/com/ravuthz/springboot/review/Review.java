package com.ravuthz.springboot.review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:56 PM
 * Email : ravuthz@gmail.com
 */

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private int rating;
    private String description;

    public Review() {
        this.id = null;
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
