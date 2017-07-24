package com.ravuthz.springboot.course;

import com.ravuthz.springboot.core.BaseEntity;
import com.ravuthz.springboot.review.Review;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:49 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class Course extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 140)
    private String title;

    @NotNull
    @Size(min = 14)
    private String link;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Course() {
        super();
        reviews = new ArrayList<>();
    }

    public Course(String title, String link) {
        this();
        this.title = title;
        this.link = link;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviews.add(review);
    }
}
