package com.ravuthz.springboot.core;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 10:07 PM
 * Email : ravuthz@gmail.com
 */

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    @Version
    private Long version;

    public BaseEntity() {
        id = null;
    }
}
