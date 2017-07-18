package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 7/18/17, 9:07 AM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);

    @Query(value = "select r.role from users u inner join user_role ur on(u.user_id=ur.user_id) inner join roles r on(ur.role_id=r.role_id) where u.email=?1", nativeQuery = true)
    List<String> findRoleByEmail(String email);
}
