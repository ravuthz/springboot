package com.ravuthz.springboot.controller;

import org.springframework.stereotype.Controller;
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

}
