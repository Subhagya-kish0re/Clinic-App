package com.example.ClinicApp.Controller;

import com.example.ClinicApp.Service.UserService;
import com.example.ClinicApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/testuser")
    public ResponseEntity<String> testUser(){

        return ResponseEntity.ok("Testing the user controller");
    }
    @GetMapping("/findbyname")
    public ResponseEntity<Optional<User>> findByUsername(@PathVariable String user){
        Optional<User> curruser=userService.findUserByName(user);
        return ResponseEntity.ok(curruser);
    }

    @GetMapping("/all")
    public List<User>findAllUser(){
        return userService.findAllUsers();
    }

    @PostMapping("/save")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String SaveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

}
