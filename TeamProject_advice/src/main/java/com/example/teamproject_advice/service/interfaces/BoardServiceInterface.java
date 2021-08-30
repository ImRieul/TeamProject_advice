package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.Board;

import java.util.List;

public interface BoardServiceInterface {
    List<Board> boardList();
    Board findById(Long id);
}
