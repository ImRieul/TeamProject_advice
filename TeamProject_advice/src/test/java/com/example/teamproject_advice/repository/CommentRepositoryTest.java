package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CommentRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private UserRepository userRepository;


    @Test //생성
    public void create() {
        Comment co = new Comment();

        co.setId(5L);
        co.setComments("배고파요");
        co.setCreatedAt(LocalDateTime.now());
        co.setCreatedBy("admin");


        Comment newComment = commentRepository.save(co);
        System.out.println(newComment);

    }
}
