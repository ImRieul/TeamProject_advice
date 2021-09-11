package com.example.teamproject_advice.controller;


import com.example.teamproject_advice.service.implement.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @PostMapping("/loginAction.do")
    public String loginAction(@RequestParam(value = "account") String account,
                              @RequestParam(value = "pw") String password) {

        if ( service.userLogin(account, password) ) { return "/home"; }
        else { return "redirect:/user/login"; }
    }

    @GetMapping("/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/registerAction.do")
    public String registerAction(String account, String pw, String phone,
                                 String gender, String color, String myTemp,
                                 String clotheStyle) {

        if ( service.userLogin(account, pw) ) { return "redirect:/user/login"; }

        System.out.println(account);
        System.out.println(pw);
        System.out.println(phone);
        System.out.println(gender);
        System.out.println(color);
        System.out.println(myTemp);
        System.out.println(clotheStyle);

        return "redirect:/user/register";

    }

}
