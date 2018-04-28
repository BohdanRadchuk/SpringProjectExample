package com.company.service;

import com.company.model.Role;
import com.company.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void save(User user);

    User findByEmail(String username);

    List<User> getAllUsers();

    User findById(String id);

    Set<Role> findAllRole(String id);

    void deleteUserById(String id);
}
