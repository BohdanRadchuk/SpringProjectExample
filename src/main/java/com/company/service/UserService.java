package com.company.service;

import com.company.model.Role;
import com.company.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByEmail(String username);

    List<User> getAllUsers();

    User findById(String id);

    List<Role> findAllRole();

    void deleteUserById(String id);
}
