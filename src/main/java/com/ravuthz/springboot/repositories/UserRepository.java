package com.ravuthz.springboot.repositories;

import com.ravuthz.springboot.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ravuthz on 7/9/17.
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
