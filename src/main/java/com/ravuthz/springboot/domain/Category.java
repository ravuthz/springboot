package com.ravuthz.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * Date : 8/12/17, 10:45 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -992248230930241426L;

    @NotEmpty(message = "Can not be null")
    private String mainCategoryName;

    @NotEmpty(message = "Can not be null")
    private String subCategoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Category(String mainCategoryName, String subCategoryName) {
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
    }
}
