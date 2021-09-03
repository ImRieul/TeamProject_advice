package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.repository.BoardRepository;
import com.example.teamproject_advice.service.interfaces.BoardServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface {

    private final BoardRepository boardRepository;

    @Override
    public Page<Board> boardList(Pageable pageable) {
        if (pageable.getSort() != Sort.unsorted()) {
            return boardRepository.findAll(pageable);
        } else {
            return boardRepository.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "id"));
        }
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Integer> paging(int i) {
        int d = (0<i)? i/5 : 0;

        int startInt = d*5;
        int endInt = d*5 +4;

        List<Integer> list = new ArrayList<>();

        for (; startInt <= endInt; startInt++) {
            list.add(startInt);
        }

        return list;
    }
}
