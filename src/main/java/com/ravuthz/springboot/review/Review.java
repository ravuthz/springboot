package com.ravuthz.springboot.review;

import com.ravuthz.springboot.core.BaseEntity;
import com.ravuthz.springboot.course.Course;
import com.ravuthz.springboot.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:56 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@NoArgsConstructor
public class Review extends BaseEntity {
    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    @NotNull
    @Size(min = 5)
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviewer;

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

}
