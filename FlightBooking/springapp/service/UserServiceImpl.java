package com.examly.springapp.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.UserNotFoundException;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User createUser(User user) throws UserNotFoundException {
        User foundUser = userRepo.findByUsername(user.getUsername());
        if(foundUser != null)
            throw new UserNotFoundException("Model : User with same name already exists");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepo.save(user);
        return user;
    }
    @Override
    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }
    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
    @Override
    public User userLogin(String email, String password) throws UserNotFoundException{
        User user = userRepo.findByEmail(email);
        if(user==null)
            throw new UserNotFoundException("User not found");
        if(passwordEncoder.matches(password, user.getPassword()))
            return user;
        throw new UserNotFoundException("User not found");
    }
}
