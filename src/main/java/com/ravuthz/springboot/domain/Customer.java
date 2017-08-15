package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

    @NotEmpty(message = "Email can not be blank")
    private String email;

    @NotEmpty (message = "Password can not be blank")
    private String password;

    @NotEmpty (message = "Name can not be blank")
    private String fullName;

    private Date registerDate;

    private boolean enabled;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ShippingAddress> shippingAddresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Code> codes = new ArrayList<>();

    public Customer(String fullName, String email, String password) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.enabled = true;
        this.registerDate = new Date();
    }

}
