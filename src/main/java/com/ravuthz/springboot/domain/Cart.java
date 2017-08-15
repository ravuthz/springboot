package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:36 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4110828160339396501L;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    private double grandTotal;

}
