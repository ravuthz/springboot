package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by Vannaravuth Yo
 * Date : 8/22/17, 8:43 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    private String houseNo;
    private String streetNo;
    private String commune;
    private String village;
    private String district;
    private String province;
    private String description;

}
