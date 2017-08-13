package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/2017, 10:09 AM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private String password;

}