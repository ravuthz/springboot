package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 7/14/17, 10:25 PM
 * Email : ravuthz@gmail.com
 */

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
