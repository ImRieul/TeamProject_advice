package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.User;

import java.util.List;

public interface UserServiceInterface {
    void create (String account, String password, String phoneNumber);
    User read(String account, String password);
    boolean existUser();
}
