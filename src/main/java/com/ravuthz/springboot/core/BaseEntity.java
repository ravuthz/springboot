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
    private final long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private int updatedBy;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "deleted_by")
    private int deletedBy;

    public BaseEntity() {
        this.id = 0L;
    }

}
