package com.ravuthz.springboot.service;

import com.ravuthz.springboot.domain.User;
import com.ravuthz.springboot.repository.RoleRepository;
import com.ravuthz.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 7/18/17, 9:50 AM
 * Email : ravuthz@gmail.com
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with email: " + email);
        } else {
            List<String> userRoles = roleRepository.findRoleByEmail(email);
            return new CustomUserDetails(user, userRoles);
        }
    }

}
