package com.ravuthz.springboot.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 10:07 PM
 * Email : ravuthz@gmail.com
 */

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    public BaseEntity() {
        id = null;
    }
}
