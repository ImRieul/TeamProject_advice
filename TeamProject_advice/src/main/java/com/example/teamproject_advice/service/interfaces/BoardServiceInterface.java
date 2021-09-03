package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardServiceInterface {
    Page<Board> boardList(Pageable pageable);
    Board findById(Long id);
    List<Integer> paging(int i);
}
