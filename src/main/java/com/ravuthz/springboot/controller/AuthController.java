package com.ravuthz.springboot.controller;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.ravuthz.springboot.domain.User;
import com.ravuthz.springboot.service.EmailService;
import com.ravuthz.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Vannaravuth Yo
 * Date : 7/18/17, 2:51 PM
 * Email : ravuthz@gmail.com
 */

@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private UserService userService;
    private EmailService emailService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthController(UserService userService, EmailService emailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.emailService = emailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(
            ModelAndView modelAndView,
            @Valid User user, BindingResult bindingResult,
            HttpServletRequest request) {

        User userExists = userService.findByEmail(user.getEmail());

        logger.debug(userExists.toString());

        if (userExists != null) {
            modelAndView.addObject("failureMessage",
                    "Oops!  There is already a user registered with the email provided.");
            bindingResult.reject("email");
        }

        if (!bindingResult.hasErrors()) {
            user.setActive(0);

            // Generate random 36-character string token for confirmation link
            user.setConfirmationToken(UUID.randomUUID().toString());

            userService.saveUser(user);
            sendMail(request, user);

            modelAndView.addObject("successMessage",
                    "A confirmation e-mail has been sent to " + user.getEmail());
        }

        modelAndView.setViewName("register");

        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        User user = userService.findByConfirmationToken(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("failureMessage",
                    "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmationForm(
            ModelAndView modelAndView,
            BindingResult bindingResult,
            @RequestParam Map requestParams,
            RedirectAttributes redir) {

        Zxcvbn passwordCheck = new Zxcvbn();
        Strength strength = passwordCheck.measure(requestParams.get("password").toString());

        if (strength.getScore() < 3) {
            bindingResult.reject("password");
            redir.addFlashAttribute("failureMessage", "Your password is too weak.  Choose a stronger one.");
            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            logger.debug(requestParams.get("token").toString());
            return modelAndView;
        }

        User userExists = userService.findByConfirmationToken(requestParams.get("token").toString());
        userExists.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password").toString()));
        userExists.setActive(1);

        logger.debug(userExists.toString());
        userService.saveUser(userExists);

        modelAndView.addObject("successMessage", "Your password has been set!");
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    private void sendMail(HttpServletRequest request, User user) {
        String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

        String mailContent = "To confirm your e-mail address, please click the link below:\n"
                + appUrl + "/confirm?token=" + user.getConfirmationToken();

        logger.debug(mailContent);

        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(user.getEmail());
        registrationEmail.setSubject("Registration Confirmation");
        registrationEmail.setText(mailContent);
        registrationEmail.setFrom("noreply@domain.com");
        emailService.sendEmail(registrationEmail);
    }
}
