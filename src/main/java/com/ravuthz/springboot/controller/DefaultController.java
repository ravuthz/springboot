package com.ravuthz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ravuthz on 7/13/17.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = {"", "/", "/home"})
    public String home() {
        return "/home";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/500")
    public String error500() {
        return "/error/500";
    }

}
