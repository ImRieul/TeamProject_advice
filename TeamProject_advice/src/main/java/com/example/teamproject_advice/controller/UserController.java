package com.example.teamproject_advice.controller;


import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.implement.UserService;
import com.example.teamproject_advice.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

//    @Autowired
//    private UserRepository userRepository;

//    @Autowired
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    //    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @GetMapping("/get")
    public String getMethod() {
        return "Hello World!";
    }

    @GetMapping("/get2")
    public String postMethod() {
        try
        {
            List<User> user = service.list();
            return user.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
}
