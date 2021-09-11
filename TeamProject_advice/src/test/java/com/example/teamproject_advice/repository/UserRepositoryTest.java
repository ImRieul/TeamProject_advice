package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        user1.setCreatedBy("admin01");

        User newUser = userRepository.save(user1);
        System.out.println(newUser);

        // insert into user values(id, account, ...)

    }

    @Test
    @Transactional
    public void read() {

//        List<User> userList = userRepository.findAll();
//
//        for (User user : userList) {
//            user.toString();
//        }

        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(user1 -> {
            System.out.println("user account : " + user1.getAccount());
            System.out.println("user board : " + user1.getBoardList().size());
        });

    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(5L);

        user.ifPresent(u -> {
            u.setAccount("juyoung");
            u.setPassword("skdkskdk");
            u.setUpdatedAt(LocalDateTime.now());
            u.setUpdatedBy("admin");

            userRepository.save(u);

        });



    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(6L);

        user.ifPresent(u -> {
            userRepository.delete(u);
        });
    }

    @Test
    public void regiTest() {
        System.out.println(userRepository.findByAccount("abc123"));
    }
}