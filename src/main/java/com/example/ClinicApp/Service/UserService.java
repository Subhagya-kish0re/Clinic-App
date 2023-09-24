package com.example.ClinicApp.Service;

import com.example.ClinicApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    Optional<User> findUserByName(String name);

    String saveUser(User user);
}
