package com.example.teamproject_advice.controller;

import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.implement.UserService;
import com.example.teamproject_advice.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/login")
    public String re() {
        return "/user/login";
    }

    @PostMapping("/loginAction.do")
    public String loginAction(@RequestParam(value = "account") String acc,
                              @RequestParam(value = "password") String pw) {

        User user = service.read(acc, pw);

        if ( user == null ) { return "redirect:/user/login";}

        return "redirect:/";
    }


    @PostMapping("/regi.do")
    public String regi(@RequestParam(value = "account") String acc,
                                 @RequestParam(value = "password") String pw,
                                 @RequestParam(value = "phoneNumber") String phone) {
        service.create(acc, pw, phone);

        return "redirect:/user/login";

    }



}
