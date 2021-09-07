package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test //생성
    public void create() {
        User user1 = new User();

        user1.setAccount("abc123");
        user1.setPassword("1234");
        user1.setStatus("ready");

        user1.setPhoneNumber("010-1234-5678");
        user1.setRegisteredAt(LocalDateTime.now());

        user1.setCreatedAt(LocalDateTime.now());
        user1.setCreatedBy("Admin3");

        User newUser = userRepository.save(user1);
        System.out.println(newUser);
    }


    @Test //읽기
    public void read() {

        List<User> userList = userRepository.findAll();

        for (User user : userList) {

            System.out.println(user.getId());
            System.out.println(user.getAccount());
            System.out.println(user.getPassword());
            System.out.println(user.getStatus());
        }
    }

    @Test //수정
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(u -> {
            u.setAccount("jy");
            u.setPassword("1234");
            u.setUpdatedAt(LocalDateTime.now());
            u.setUpdatedBy("admin");

            userRepository.save(u);

        });

    }

    @Test //삭제
    public void delete() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(u -> {
            userRepository.delete(u);
        });
    }
}
