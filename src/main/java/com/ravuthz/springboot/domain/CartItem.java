package com.ravuthz.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:38 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class CartItem extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6050058936968302003L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long cartItemId;

    @ManyToOne
//    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
//    @JoinColumn(name = "productId")
    private Product product;

    private double totalPriceDouble;

    private int quantity;

}