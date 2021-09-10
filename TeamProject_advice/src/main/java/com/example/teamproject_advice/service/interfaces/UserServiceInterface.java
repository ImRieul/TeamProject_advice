package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> list() throws Exception;
}
