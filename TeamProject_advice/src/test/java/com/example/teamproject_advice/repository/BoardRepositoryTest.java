package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class BoardRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void create() {
        for (int i=0; i<100; i++) {
            Board board = Board.builder()
                            .title(i + "번째 게시글")
                            .content(i + "번째 게시글입니다.")
                            .writer(1L)
                            .registeredAt(LocalDateTime.now())
                            .createdAt(LocalDateTime.now())
                            .createdBy("admin")
                            .build();

            boardRepository.save(board);
        }
    }
}
