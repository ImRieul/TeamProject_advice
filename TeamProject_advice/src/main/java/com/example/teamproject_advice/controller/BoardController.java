package com.example.teamproject_advice.controller;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.service.implement.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public String list(@RequestParam(value = "search", required = false) String search,
                       Model model, Pageable pageable) {

        //         검색한 내용이 없을 때 (search param이 없을 때)
        Page<Board> boardPage = ( search.isEmpty() )? service.boardListPage(pageable) : service.searchBoardPage(search, pageable);

        model.addAttribute("list", boardPage);                          // page list를 전송
        model.addAttribute("paging", service.paging(pageable));         // 페이지 번호를 위한 list
        model.addAttribute("page", service.checkPageable(pageable));    // 현재 페이지 정보 detail에 전달용
        model.addAttribute("lastPageNumber", service.boardListLastPage(pageable.getPageSize()) -1);   // 마지막 페이지 확인용

        model.addAttribute("search", search);

        return "board/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id,
                         @RequestParam("size") int size,
                         Model model) {

        Board board = service.findById(id);
        model.addAttribute("board", board);

        model.addAttribute("boardNext", service.findById(id+1));        // 다음 글
        model.addAttribute("boardPrev", service.findById(id-1));        // 이전 글

        // 목록으로
        model.addAttribute("page", service.returnPageNumber(id, size));
        model.addAttribute("size", size);

        // 댓글 테스트
        Map<String, String> testMap = new HashMap<>();

        testMap.put("registeredAt", "2021-09-01 12:00");
        testMap.put("comment", "테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 ");
        testMap.put("nickname", "멍청한비둘기들");

        model.addAttribute("comment", testMap);

        return "board/detail";
    }
}
