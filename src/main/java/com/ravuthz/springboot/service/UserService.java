package com.ravuthz.springboot.service;

import com.ravuthz.springboot.domain.User;

/**
 * Created by ravuthz on 7/9/17.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}