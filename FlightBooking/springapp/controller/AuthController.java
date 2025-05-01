package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    UserService userService;
    @PostMapping("/api/register")
    public ResponseEntity<User> addUser(@RequestBody User user) throws UserNotFoundException{
        return ResponseEntity.status(201).body(userService.createUser(user));
    }
    // @PostMapping("api/login")
    // public ResponseEntity<User> loginUser(@RequestBody User user){
    //     return ResponseEntity.status(200).body(userService.loginUser(user));
    // }
    @GetMapping("/api/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId){
        return ResponseEntity.status(200).body(userService.getUserById(userId));
    }
    @GetMapping("/api/user")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }
    @PostMapping("/api/login")
    public ResponseEntity<User> userLogin(@RequestBody User user) throws UserNotFoundException{
        User existingUser = userService.userLogin(user.getEmail(), user.getPassword());
        existingUser.setPassword(null);
        return ResponseEntity.status(200).body(existingUser);
    }
}
