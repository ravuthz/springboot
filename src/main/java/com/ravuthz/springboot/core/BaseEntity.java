package com.ravuthz.springboot.core;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/2017, 2:33 PM
 * Email : ravuthz@gmail.com
 */

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Version
    private Integer version;

    private Date dateCreated;
    private Date lastUpdated;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated == null) {
            dateCreated = new Date();
        }
    }
}
