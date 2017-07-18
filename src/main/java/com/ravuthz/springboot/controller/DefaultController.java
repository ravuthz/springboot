package com.ravuthz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vannaravuth Yo
 * Date : 7/18/17, 10:26 AM
 * Email : ravuthz@gmail.com
 */

@Controller
public class DefaultController {

    @RequestMapping({"/", "/home"})
    public String index() {
        return "home";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin/index";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user/index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public void postRegister() {

    }
}
