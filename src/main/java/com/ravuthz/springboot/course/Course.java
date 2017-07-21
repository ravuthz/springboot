package com.ravuthz.springboot.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:49 PM
 * Email : ravuthz@gmail.com
 */

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String title;
    private String link;

    // TODO: We are duplicating code here for every single entity.
    public Course() {
        this.id = null;
    }

    public Course(String title, String link) {
        this();
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
