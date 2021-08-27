package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class ItemRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test //생성
    public void create() {
        Item item1 = new Item();

        item1.setId(1L);
        item1.setStatus("ready");
        item1.setName("abcJean");
        item1.setTitle("Pants");
        item1.setContent("sangsesulmyeng");
        item1.setPrice(10000);
        item1.setBrandName("brand010101");

        item1.setRegisteredAt(LocalDateTime.now());

        item1.setCreatedAt(LocalDateTime.now());
        item1.setCreatedBy("admin01");

        item1.setPartnerId(1L);


        Item newItem = itemRepository.save(item1);
        System.out.println(newItem);
    }

//    @Test //읽기
//    public void read() {
//
//        List<Item> itemList = itemRepository.findAll();
//
//        for (Item item : itemList) {
//
//            System.out.println(item.getId());
//            System.out.println(item.getStatus());
//            System.out.println(item.getName());
//            System.out.println(item.getTitle());
//            System.out.println(item.getContent());
//            System.out.println(item.getPrice());
//            System.out.println(item.getBrand_name());
//            System.out.println(item.getBrand_name());
//        }
//    }

//    @Test //수정
//    public void update() {
//        Optional<User> user = userRepository.findById(2L);
//
//        user.ifPresent(u -> {
//            u.setAccount("jy");
//            u.setPassword("1234");
//            u.setUpdatedAt(LocalDateTime.now());
//            u.setUpdatedBy("admin");
//
//            userRepository.save(u);
//
//        });
//
//    }
//
//    @Test //삭제
//    public void delete() {
//        Optional<User> user = userRepository.findById(2L);
//
//        user.ifPresent(u -> {
//            userRepository.delete(u);
//        });
//    }
}