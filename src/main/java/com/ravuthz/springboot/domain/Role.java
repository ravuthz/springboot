package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:44 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

    private String email;
    private String authority;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Role(String email, String authority) {
        this.email = email;
        this.authority = authority;
    }

}
