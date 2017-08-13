package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 8/13/17, 4:54 PM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByEmail(String email);
}
