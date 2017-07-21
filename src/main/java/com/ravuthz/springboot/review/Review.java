package com.ravuthz.springboot.review;

import com.ravuthz.springboot.core.BaseEntity;
import com.ravuthz.springboot.course.Course;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:56 PM
 * Email : ravuthz@gmail.com
 */

@Entity
public class Review extends BaseEntity {
    private int rating;
    private String description;

    @ManyToOne
    private Course course;

    public Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
