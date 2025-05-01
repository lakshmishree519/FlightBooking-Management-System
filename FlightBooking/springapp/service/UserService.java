package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.User;

public interface UserService {
    User createUser(User user) throws UserNotFoundException;
    //User loginUser(User user);
    User getUserById(int userId);
    List<User> getAllUser();
    public User userLogin(String email,String password) throws UserNotFoundException;
}
