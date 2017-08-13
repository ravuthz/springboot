package com.ravuthz.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:54 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class CustomerOrderShippingAddress extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 9001223266668134199L;

//    @Id
//    @GeneratedValue
//    private Long addressId;

    private String fullName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Long originalShippingAddressId;

    @OneToOne
//    @JoinColumn(name = "customerOrderId")
    @JsonIgnore
    private CustomerOrder customerOrder;

}
