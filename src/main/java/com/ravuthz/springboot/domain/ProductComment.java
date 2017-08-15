package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:42 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "productComments")
public class ProductComment extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2586167050875661578L;

    private String content;

    private int commentStarts;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private Date commentDate;

}
