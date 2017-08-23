package com.ravuthz.springboot.core;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/17, 1:34 AM
 * Email : ravuthz@gmail.com
 */

@Data
@MappedSuperclass
public class ItemBaseEntity extends BaseEntity {
    private String name;
    private String code;
    // TODO: All items should have name and code except human
}
