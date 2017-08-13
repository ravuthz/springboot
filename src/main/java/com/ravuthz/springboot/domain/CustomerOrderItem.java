package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:53 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class CustomerOrderItem extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8892553931694642183L;

//    @Id
//    @GeneratedValue
//    private Long customerOrderItemId;

    private Long productId;
    private int productQuantity;
    private double productPrice;
    private String productName;

    @ManyToOne
//    @JoinColumn(name = "customerOrderId")
    private CustomerOrder customerOrder;

}
