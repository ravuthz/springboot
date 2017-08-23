package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:47 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "codes")
public class Code extends BaseEntity {

    private int type;
    private String text;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
