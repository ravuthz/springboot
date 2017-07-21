package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/2017, 10:09 AM
 * Email : ravuthz@gmail.com
 */

@Entity
public class User extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}