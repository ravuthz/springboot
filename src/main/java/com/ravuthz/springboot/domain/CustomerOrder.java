package com.ravuthz.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:52 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "customerOrders")
public class CustomerOrder extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 584092333516618686L;

    private double orderTotalPrice;

    @OneToOne
    @JoinColumn(name = "addressId")
    private CustomerOrderShippingAddress customerOrderShippingAddress;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private List<CustomerOrderItem> customerOrderItems = new ArrayList<>();

}