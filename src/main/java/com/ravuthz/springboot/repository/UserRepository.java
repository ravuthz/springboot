package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 7/14/17, 10:25 PM
 * Email : ravuthz@gmail.com
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Get a user by email that implement by Spring Data JPA and we
     * also can custom this function by implements this interface and
     * override this function then filter what do you want by your self
     * @param email
     * @return User
     */
    User findByEmail(String email);

    /*TODO: This is multiple lines comment */
    //TODO: Create function that field all users has role ADMIN
    //TODO: There are todo comments that describe what do next or plan
}
