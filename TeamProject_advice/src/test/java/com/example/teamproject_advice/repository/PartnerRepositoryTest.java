package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PartnerRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
//        insert info user values(id, account);
        Partner part1 = new Partner();

        part1.setId(1L);
        part1.setName("JYB");
        part1.setStatus("ready");
        part1.setAddress("대전 용문");
        part1.setCall_center("010-1234-5678");
        part1.setPartner_number("010-1111-1111");
        part1.setBusiness_number("1234567891011121");
        part1.setCeo_name("배쥬용");

        part1.setRegistered_at(LocalDateTime.now());

        part1.setCreated_at(LocalDateTime.now());
        part1.setCreated_by("admin01");

        part1.setCategory_id(1L);

        Partner newPartner = partnerRepository.save(part1);
        System.out.println(newPartner);

        // insert into user values(id, account, ...)

    }

//    @Test
//    public void read() {
//
//        List<User> userList = userRepository.findAll();
//
//        for (User user : userList) {
//            user.toString();
//        }
//    }
//
//    @Test
//    public void update() {
//        Optional<User> user = userRepository.findById(5L);
//
//        user.ifPresent(u -> {
//            u.setAccount("juyoung");
//            u.setPassword("skdkskdk");
//            u.setUpdatedAt(LocalDateTime.now());
//            u.setUpdatedBy("admin");
//
//            userRepository.save(u);
//
//        });
//
//
//
//    }
//
//    @Test
//    public void delete() {
//        Optional<User> user = userRepository.findById(6L);
//
//        user.ifPresent(u -> {
//            userRepository.delete(u);
//        });
//    }
//
}