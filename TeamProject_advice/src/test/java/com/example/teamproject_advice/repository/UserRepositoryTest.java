package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class UserRepositoryTest extends TeamProjectAdviceApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create() {
        User user = new User();
        user.setAccount("kiju");
        user.setPassword("1234");
        user.setStatus("ready");
        user.setPhoneNumber("010-2221-1111");
        user.setRegistered_at(LocalDateTime.now());

//        user.setCreated_at(LocalDateTime.now());
//        user.setCreated_by("admin");

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
        user.toString();
    }

    @Test
    public void read() {
        List<User> user = userRepository.findAll();
        System.out.println(user);
    }
}
