package com.ravuthz.springboot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by ravuthz on 7/9/17.
 */
@Controller
public class HomeController {

    // inject via application.properties
    @Value("${spring.application.name}")
    private String appName = "Spring Boot";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("appName", this.appName);
        model.put("viewPath", "/src/main/resources/templates/welcome.html");
        return "welcome";
    }

}