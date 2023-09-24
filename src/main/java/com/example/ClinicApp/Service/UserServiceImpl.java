package com.example.ClinicApp.Service;

import com.example.ClinicApp.Repository.UserRepository;
import com.example.ClinicApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public String saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        User user1= userRepository.save(user);
        if(user1!=null && user1.getUsername()!=""){
            return "User created";
        }else {
            return "Please try again";
        }
    }
}
