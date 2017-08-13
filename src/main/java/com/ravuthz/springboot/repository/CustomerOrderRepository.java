package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.CustomerOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 8/13/17, 4:05 PM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface CustomerOrderRepository extends PagingAndSortingRepository<CustomerOrder, Long> {
}
