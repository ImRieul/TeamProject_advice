package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// Service interface : 오타 방지, (메서드 요약집)

public interface BoardServiceInterface {
    Page<Board> boardListPage(Pageable pageable);
    int boardListLastPage(int size);
    Pageable checkPageable(Pageable pageable);
    Board findById(Long id);
    List<Integer> paging(Pageable pageable);
    int returnPageNumber(Long id, int size);
}
