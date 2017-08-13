package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:49 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class ShippingAddress extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 921227846105947776L;

//    @Id
//    @GeneratedValue
//    private Long addressId;

    @NotEmpty(message="Please fill in your name")
    private String fullName;

    @NotEmpty(message="Please fill in your phone number")
    private String phoneNumber;

    @NotEmpty(message="Address can not be null")
    private String address;

    @NotEmpty(message="City can not be null")
    private String city;

    @NotEmpty(message="State can not be null")
    private String state;

    @NotEmpty(message="Country can not be null")
    private String country;

    @NotEmpty(message="ZipCode can not be null")
    private String zipCode;

    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public String toString(boolean isShipping) {
        if (isShipping){
            return "shippingAddress{" +
                    "fullName='" + fullName + '\'' +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", country='" + country + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }else{
            return "billingAddress{" +
                    "fullName='" + fullName + '\'' +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", country='" + country + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

}
