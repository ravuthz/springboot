package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:43 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1836726872479056197L;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String fullName;

    private boolean enabled;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ProductComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Code> codes = new ArrayList<>();

    public Customer(String fullName, String email, String password) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.enabled = true;
    }

}
