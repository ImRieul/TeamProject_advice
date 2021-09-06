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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface {

    private final BoardRepository boardRepository;

    @Override
    public Page<Board> boardListPage(Pageable pageable) {
        int lastPage = boardListLastPage(pageable.getPageSize()) -1;
        int valPage = pageable.getPageNumber() -1;

        Pageable setPageable = (valPage > lastPage)? checkPageable( PageRequest.of(lastPage, pageable.getPageSize(), pageable.getSort()) ) : checkPageable( pageable );

        return boardRepository.findAll(setPageable);
    }

    @Override
    public Pageable checkPageable(Pageable pageable) {
        return (pageable.getSort() != Sort.unsorted())? pageable : PageRequest.of(0, 10, Sort.Direction.DESC, "id");
    }


    @Override
    public int boardListLastPage(int size) {
        int lastPage = boardRepository.findAll(PageRequest.of(0, size, Sort.Direction.DESC, "id")).getTotalPages();
        return lastPage;
    }


    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Override
    public List<Integer> paging(Pageable pageable) {
        int page = pageable.getPageNumber();

        int d = (0<page)? page/5 : 0;

        int startInt = d*5;
        int endInt = d*5 +4;

        List<Integer> list = new ArrayList<>();

        for (; startInt <= endInt; startInt++) {
            if ( !boardRepository.findAll( PageRequest.of(startInt, pageable.getPageSize(), pageable.getSort()) ).isEmpty() )
            {
                list.add(startInt);
            }
        }

        return list;
    }

    @Override
    public int returnPageNumber(Long id, int size) {
        List<Board> descFindAll = boardRepository.findAll();
        Collections.reverse(descFindAll);

        return Math.toIntExact(descFindAll.indexOf(id) / size);
    }

    @Override
    public Page<Board> searchBoardPage(String search, Pageable pageable) {
        return boardRepository.findByTitleContaining(search, pageable);
    }
}
