package com.ravuthz.springboot.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ravuthz on 7/9/17.
 */

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GenericGenerator(
            name = "roleSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "role_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
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

}
