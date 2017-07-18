package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 7/18/17, 9:05 AM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    User findByConfirmationToken(String confirmationToken);

//    @Query(value = "select email, password, active from users u where email=?1", nativeQuery = true)
//    User findByEmail(String email);
}
