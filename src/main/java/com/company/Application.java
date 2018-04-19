package com.company;


import com.company.model.Role;
import com.company.model.User;
import com.company.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;



@SpringBootApplication
@EnableJpaRepositories("com.company.repository")
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(com.company.Application.class);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setPassword("123");
        user.setEmail("email@asd.com");
        user.setFirstName("Firstname");
        user.setLastName("LastName");
        Set<Role> roles = new HashSet<Role>() {
        };
        roles.add(new Role());
        //user.setRoles(roles);

        //userService.save(user);
        System.out.println(userService.getAllUsers());

    }

}



