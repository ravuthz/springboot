package com.ravuthz.springboot.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by Vannaravuth Yo
 * Date : 7/18/17, 8:58 AM
 * Email : ravuthz@gmail.com
 */

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GenericGenerator(
            name = "roleSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "role_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "roleSequenceGenerator")
    @Column(name = "role_id")
    private int id;

    @Column(name = "role")
    private String role;

    public Role() {
        //
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
