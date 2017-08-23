package com.ravuthz.springboot.domain;

import com.ravuthz.springboot.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/12/17, 10:41 PM
 * Email : ravuthz@gmail.com
 */

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6989243970039135205L;

    @NotEmpty
    @Length(max = 255)
    private String name;

    @Min(value = 0)
    private double price;

    @Length(max = 255)
    private String summary;

    @NotEmpty
    private String condition;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "views", nullable = false)
    private long views = 0;

    @Min(value = 0)
    private int unitInStock;

    @Length(max = 255)
    private String tagsW;

    @Transient
    private MultipartFile image;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product(String name, double price, String summary, String condition, String description, int unitInStock) {
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.condition = condition;
        this.description = description;
        this.unitInStock = unitInStock;
        this.views = 0;
        this.tagsW = "";
    }

}
