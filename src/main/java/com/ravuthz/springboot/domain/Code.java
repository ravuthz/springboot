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
public class Code extends BaseEntity {

//    @Id
//    @GeneratedValue
//    private Long codeId;

    private String codeStr;
    private int codeType; // 0:active, 1: reset PW

    @Column(columnDefinition="DATETIME")
    private Date codeDate;

    @ManyToOne
//    @JoinColumn(name = "customerId")
    private Customer customer;

}
