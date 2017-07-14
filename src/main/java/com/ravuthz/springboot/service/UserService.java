package com.ravuthz.springboot.service;

import com.ravuthz.springboot.domain.User;

/**
 * Created by Vannaravuth Yo
 * Date : 7/14/17, 10:25 PM
 * Email : ravuthz@gmail.com
 */

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}