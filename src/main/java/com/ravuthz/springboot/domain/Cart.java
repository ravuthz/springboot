package com.ravuthz.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cart extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4110828160339396501L;

//    @Id
//    @GeneratedValue
//    private Long cartId;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @OneToMany
    @JoinTable(name = "carts", joinColumns = @JoinColumn(name = "id"))
    private List<CartItem> cartItems;

    @OneToOne
//    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

}
