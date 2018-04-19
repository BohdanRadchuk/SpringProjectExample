package com.company.service;

import com.company.controller.UserController;
import com.company.model.Role;
import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

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
        userRepository.save(user);
        System.out.println(user.getPassword());
        System.out.println(bCryptPasswordEncoder.matches("123",user.getPassword()));
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
        if (userRepository.findById(id)!=null) {
            User user = userRepository.findById(id).get();
            return user;
        }
        else return null;
    }

    @Override
    public List<Role> findAllRole() {
        return null;
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
