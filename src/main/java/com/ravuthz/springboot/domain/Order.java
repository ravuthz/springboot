package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:52 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 584092333516618686L;

    private double orderTotalPrice;

    @OneToOne
    @JoinColumn(name = "addressId")
    private OrderShippingAddress orderShippingAddress;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

}