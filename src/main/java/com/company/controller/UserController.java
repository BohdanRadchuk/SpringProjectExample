package com.company.controller;

import com.company.model.User;
import com.company.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /*   @PostMapping("/registration")
       public String register(@Valid User user, BindingResult bindingResult) {
           ModelAndView modelAndView = new ModelAndView();
           *//*User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {*//*
            userService.save(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");


        return "redirect:login";
    }*/
    @PostMapping("/registration")
    public String register(@ModelAttribute User user) {
        user.setId(UUID.randomUUID());
        System.out.println(userService.findByEmail(user.getEmail()));
        if (userService.findByEmail(user.getEmail()) == null) {
            userService.save(user);
        }
        System.out.println(userService.findByEmail("mail@mail.com"));
        System.out.println(user.getFirstName());
        System.out.println(userService.getAllUsers());

        //System.out.println(model.get("id"));
        //user.setId();


        return "redirect:login";
    }
}
