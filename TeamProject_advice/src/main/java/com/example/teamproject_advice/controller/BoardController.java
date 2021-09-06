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
@Controller                         // controller임을 명시(spring boot), 학원 : 홈페이지 > 공부 참고 참조
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    // /board/list로 연결됨
    // parameter로는 search, Model, Pageable( page, size, sort )가 있음
    @GetMapping("/list")
    public String list(@RequestParam(value = "search", required = false) String search,
                       Model model, Pageable pageable) {

        //         검색한 내용이 없을 때 (search param이 없을 때)
        Page<Board> boardPage = ( search == null || search.isEmpty() )? service.boardListPage(pageable) : service.searchBoardPage(search, service.checkPageable(pageable));

        // model(return) 에 값을 전송
        model.addAttribute("list", boardPage);                          // list(key), boardPage(value, Page type)
        model.addAttribute("paging", service.paging(pageable, boardPage.getTotalPages()));         // paging(key), 페이지 번호를 위한 list(value, List type)
        model.addAttribute("page", service.checkPageable(pageable));    // page(key), 현재 페이지 정보 detail에 전달용(value, Pageable type)
        model.addAttribute("lastPageNumber", service.boardListLastPage(pageable.getPageSize() -1, search));   // lastPageNumber(key), 마지막 페이지 확인용(value, int type)

        model.addAttribute("search", search);       // search(key), value String type

        return "board/list";        // board/list.html로 연결
    }

    // /board/detail로 연결됨
    // parameter로는 id, size, Model이 있음
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id,
                         @RequestParam("size") int size,
                         Model model) {

        Board board = service.findById(id);                 // id로 검색해서 테이블의 행 가져오기
        model.addAttribute("board", board);     // board(key), board(value, Board type)

        // model(return) 에 값을 전송
        model.addAttribute("boardNext", service.findById(id+1));        // boardNext(key), 다음 글(value, board type)
        model.addAttribute("boardPrev", service.findById(id-1));        // boardPrev(key), 이전 글(value, board type)

        // 목록으로
        model.addAttribute("page", service.returnPageNumber(id, size)); // page(key), 목록 번호(value, int type)
        model.addAttribute("size", size);                               // size(key), page 설정 size(value, int type)

        // 댓글 테스트용
        Map<String, String> testMap = new HashMap<>();

        testMap.put("registeredAt", "2021-09-01 12:00");
        testMap.put("comment", "테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 ");
        testMap.put("nickname", "멍청한비둘기들");

        model.addAttribute("comment", testMap);     // comment(key), testMap(value, May<String, String> type)

        return "board/detail";
    }
}
