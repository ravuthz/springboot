package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:38 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "cartItems")
public class CartItem extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6050058936968302003L;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalPrice;

}