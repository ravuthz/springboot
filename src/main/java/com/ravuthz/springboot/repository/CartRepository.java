package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 8/13/17, 3:59 PM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
