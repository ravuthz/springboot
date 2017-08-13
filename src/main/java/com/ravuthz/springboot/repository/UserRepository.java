package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.configure.API;
import com.ravuthz.springboot.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/2017, 10:10 AM
 * Email : ravuthz@gmail.com
 */

@RepositoryRestResource(collectionResourceRel = API.USER_PATH, path = API.USER_PATH)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByName(@Param("name") String name);
}