package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.repository.BoardRepository;
import com.example.teamproject_advice.service.interfaces.BoardServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface {

    private final BoardRepository boardRepository;

    @Override
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
}
