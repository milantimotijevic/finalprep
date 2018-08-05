package com.preparation.controller;

import com.preparation.dao.UserRepository;
import com.preparation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/test")
    public String test() {
        return "Test successful!";
    }

    @RequestMapping(value="/message")
    public String message() {
        return "Today is a lovely day";
    }

    @RequestMapping(value="/test2")
    public String test2() {
        return "Test 2 successful";
    }

    @RequestMapping(value="/productname")
    public String product() {
        return "returning product";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User newUser) {
        newUser.setRole(User.Role.USER);
        newUser.setBalance(0);
        return userRepository.save(newUser);
    }

}
