package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:46 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
public class ProductTag extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6771981048033259765L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long tagId;

    @NotEmpty(message = "Can not be null")
    private String tagContents;

    @ManyToOne
//    @JoinColumn(name = "productId")
    private Product product;

}
