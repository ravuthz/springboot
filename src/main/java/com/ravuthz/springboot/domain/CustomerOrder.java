package com.ravuthz.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:52 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class CustomerOrder extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 584092333516618686L;

//    @Id
//    @GeneratedValue
//    private Long customerOrderId;

    private double orderTotalPrice;

    @Column(columnDefinition="DATETIME")
    private Date orderDate;

    @OneToOne
//    @JoinColumn(name = "addressId")
    @JsonIgnore
    private CustomerOrderShippingAddress customerOrderShippingAddress;

    @ManyToOne
//    @JoinColumn(name = "customerId")
    private Customer customer;

//    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany
    private List<CustomerOrderItem> customerOrderItems;

}