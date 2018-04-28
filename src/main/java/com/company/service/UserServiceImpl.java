package com.company.service;

import com.company.controller.UserController;
import com.company.model.Role;
import com.company.model.User;
import com.company.repository.RoleRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

   /* @Autowired
    private RoleRepository roleRepository;
*/
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        System.out.println(user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getPassword());

  /*      Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        System.out.println(user.getRoles());
  */      userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        UUID uuid = UUID.fromString(id);/*
        if (userRepository.findById(uuid) != null) {
            User user = userRepository.findById(uuid).get();
            return user;
        } else return null;*/
        return userRepository.findById(uuid).get();
    }


    @Override
    public Set<Role> findAllRole(String id) {
        User user = findById(id);
        return user.getRoles();

    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
