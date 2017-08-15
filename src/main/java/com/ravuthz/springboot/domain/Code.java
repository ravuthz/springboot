package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:47 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "codes")
public class Code extends BaseEntity {

    private String text;
    private int type; // 0:active, 1: reset PW
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
