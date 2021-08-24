package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
//        insert info user values(id, account);
        User user1 = new User();

        user1.setAccount("ju02");
        user1.setPassword("dksk");
        user1.setStatus("ready");

        user1.setPhoneNumber("010-0000-0000");
        user1.setRegisteredAt(LocalDateTime.now());

        user1.setCreatedAt(LocalDateTime.now());
        user1.setUpdatedBy("admin01");

        User newUser = userRepository.save(user1);
        System.out.println(newUser);

        // insert into user values(id, account, ...)

    }
}