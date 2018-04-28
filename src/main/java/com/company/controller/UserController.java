package com.company.controller;

import com.company.model.User;
import com.company.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registration")
    public String registration() {
        System.out.println("registration get");
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
        System.out.println("registration post " + userService.findByEmail(user.getEmail()));
        if (userService.findByEmail(user.getEmail()) == null) {     //checking for email in db
            userService.save(user);
        }
        else {
            System.err.println("email is already used");
        }
        System.out.println(userService.findByEmail("mail@mail.com"));
        System.out.println(user.getFirstName());
        System.out.println(userService.getAllUsers());

        //System.out.println(model.get("id"));
        //user.setId();


        return "redirect:login";
    }

    @GetMapping("/userslist")
    public String usersInfo (Model model){
        System.out.println("userslist get ");

        //List users = userService.getAllUsers();

        model.addAttribute("list", userService.getAllUsers());

        return "userslist";
    }

    @PostMapping("/edit/userslist")
    public String editUser(@RequestParam String id, boolean editbool){
        System.out.println("edit/userslist - get \nedit variable" + editbool);
        System.out.println(id + "  - id");
        UUID uuid = UUID.fromString(id);
        System.out.println(uuid+" in postmap");
        User user = userService.findById(id);

        System.out.println("userslist edit here");
        if (editbool){
            System.out.println("we are in edit register");
            registration();
        }

//        System.out.println(model.containsAttribute("id"));
        System.out.println(user +" this is our user");
  //      System.out.println(model.containsAttribute("id"));
        return "registration";
    }
}
