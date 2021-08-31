package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
import com.example.teamproject_advice.model.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BoardRepositoryTest extends TeamProjectAdviceApplicationTests {

    @Autowired
    private BoardRepository boardRepository;
    protected PageRequest pageRequest;

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

    @Test
    public void readTest() {
//        List<Board> list = boardRepository.findByIdLessThanAndIdGreaterThanEqualOrderByIdDesc(0L, 10L);
//        for (Board board : list) {
//            System.out.println(board.getTitle());
//        }
//
//        if (list.isEmpty()) {
//            System.out.println("값이 없습ㄴ디ㅏㄴ");
//        }

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<Board> boardPage = boardRepository.findAll(pageRequest);

        for (Board board : boardPage) {
            System.out.println("board title : " + board.getTitle());
        }
    }
}
