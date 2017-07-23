package com.ravuthz.springboot.review;

import com.ravuthz.springboot.user.User;
import com.ravuthz.springboot.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Vannaravuth Yo
 * Date : 7/23/17, 2:22 PM
 * Email : ravuthz@gmail.com
 */

@Component
@RepositoryEventHandler
public class ReviewEventHandler {
    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        System.out.println("username: " + username);
        System.out.println("authorizer: " + user);
        review.setReviewer(user);
    }
}
