package com.ravuthz.springboot.core;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/17, 1:36 AM
 * Email : ravuthz@gmail.com
 */

@Data
@MappedSuperclass
public class HumanBaseEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDay;
    // TODO: All users should have identity information
}
