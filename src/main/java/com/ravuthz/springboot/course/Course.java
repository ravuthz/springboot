package com.ravuthz.springboot.course;

import com.ravuthz.springboot.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:49 PM
 * Email : ravuthz@gmail.com
 */

@Entity
public class Course extends BaseEntity {
    private String title;
    private String link;

    public Course() {
        super();
    }

    public Course(String title, String link) {
        super();
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
