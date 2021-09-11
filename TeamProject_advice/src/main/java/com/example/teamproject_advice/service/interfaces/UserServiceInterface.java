package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.User;

import java.util.List;

public interface UserServiceInterface {

    List<String> clotheStyleList();


    boolean userLogin(String account, String password);
    boolean isAccount(String account);
    boolean isPhoneNumber(String phoneNumber);
}
