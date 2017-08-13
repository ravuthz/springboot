package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 8/13/17, 10:48 PM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByName(String name);
}
