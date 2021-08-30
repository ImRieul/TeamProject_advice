package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.repository.BoardRepository;
import com.example.teamproject_advice.service.interfaces.BoardServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface {

    private final BoardRepository boardRepository;


    @Override
    public List<Board> boardList() {
        return boardRepository.findAll();
    }
}
