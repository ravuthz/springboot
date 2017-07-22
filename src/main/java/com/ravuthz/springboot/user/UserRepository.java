package com.ravuthz.springboot.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Vannaravuth Yo
 * Date : 7/23/17, 1:00 AM
 * Email : ravuthz@gmail.com
 */

@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
