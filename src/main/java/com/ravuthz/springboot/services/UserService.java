package com.ravuthz.springboot.services;

import com.ravuthz.springboot.domains.User;

/**
 * Created by ravuthz on 7/9/17.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}