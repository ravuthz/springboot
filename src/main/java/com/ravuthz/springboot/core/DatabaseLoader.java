package com.ravuthz.springboot.core;

import com.ravuthz.springboot.domain.User;
import com.ravuthz.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:24 PM
 * Email : ravuthz@gmail.com
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("Application was running");
        System.out.println("Creating user ...");
        User user = new User();
        user.setName("Ravuthz");
        user.setEmail("ravuthz@gmail.com");
        user.setPhone("0964577770");
        user.setPassword("1L0V3Y0U");

        users.save(user);
    }
}
