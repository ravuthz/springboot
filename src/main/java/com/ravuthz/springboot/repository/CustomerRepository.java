package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 8/13/17, 4:04 PM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findByEmail(String email);
}
