package com.example.teamproject_advice.controller;


import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.service.implement.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    // 로그인 창
    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    // 로그인 요청
    @PostMapping("/loginAction.do")
    public String loginAction(@RequestParam(value = "account") String account,
                              @RequestParam(value = "pw") String password) {

        if ( service.isUser(account, password) ) { return "/home"; }
        else { return "redirect:/user/login"; }
    }

    // 회원가입 창
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("clotheStyleList", service.clotheStyleList());
        return "/user/register";
    }

    // 회원가입 요청
    @PostMapping("/registerAction.do")
    public String registerAction(String account, String pw, String phone,
                                 String gender, String color, String myTemp,
                                 String clotheStyle) {

        if ( service.isUser(account, pw) ) { return "redirect:/user/register"; }
        if ( service.isPhoneNumber(phone) ) { return "redirect:/user/register"; }

        User user = User.builder()
                .account(account)
                .password(pw)
                .phoneNumber(phone)
                .gender(gender)
                .color(color)
                .myTemp(myTemp)
                .clotheStyle(clotheStyle)
                .build();

        service.registerUser(user);

        return "redirect:/user/login";

    }

}
