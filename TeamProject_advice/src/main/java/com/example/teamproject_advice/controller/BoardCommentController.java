package com.example.teamproject_advice.controller;

import com.example.teamproject_advice.dto.BoardCommentRequest;
import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.BoardComment;
import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.implement.BoardCommentService;
import com.example.teamproject_advice.service.implement.BoardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RestController
@RequestMapping("/comment")
public class BoardCommentController {

    @NonNull
    UserRepository userRepository;
    @NonNull
    BoardCommentService boardCommentService;

    //생성
    @PostMapping("/add/comment")
    public ResponseEntity<List<BoardComment>> addComment(@PathVariable Long board,
                                                         @RequestBody BoardCommentRequest commentrequest, Principal principal) {
        commentrequest.setBoard(board);
        commentrequest.setCreated_by(principal.getName());
        Optional<User> findNo= userRepository.findById(Long.valueOf(principal.getName()));
        findNo.ifPresent(finduserNo -> {
            commentrequest.setUser(finduserNo.getId());
            BoardComment comm = this.boardCommentService
                    .createComment(MapperUtil.convert(commentrequest, BoardComment.class)
                    ,finduserNo,commentrequest.getBoard());
        });

        return new ResponseEntity<>(this.boardCommentService
                .ListBoardComment(board), HttpStatus.CREATED);
    }

    // 읽기
    @GetMapping("/read/comment")
    public ResponseEntity<List<BoardComment>> addComment(@PathVariable Long board){
        return new ResponseEntity<>(this.boardCommentService
                .ListBoardComment(board),HttpStatus.CREATED);
    }

    // 삭제
    @DeleteMapping("/delete/comment")
    public ResponseEntity<List<BoardComment>> addComment(@PathVariable Long board,@PathVariable Long commentNo) {
        return new ResponseEntity<>(this.boardCommentService
                .DeleteBoardComment(commentNo,board),HttpStatus.CREATED);
    }

    // 수정
    @PutMapping("/modify/comment")
    public ResponseEntity<List<BoardComment>> modifyComment(@PathVariable Long board, @PathVariable Long commentNo,
                                                            @RequestBody BoardCommentRequest boardCommentRequest, Principal principal) {
        boardCommentRequest.setCreated_by(principal.getName());

        return new ResponseEntity<>(this.boardCommentService
                .ModifyComments(MapperUtil.convert(boardCommentRequest, BoardComment.class),commentNo,board),HttpStatus.CREATED);
    }

}

//    public String list(@RequestParam(value = "search", required = false) String search,
//                       Model model, Pageable pageable) {
//
////        if ( search.isEmpty() ) {
//            Page<Board> boardList = service.boardListPage(pageable);
//            model.addAttribute("list", boardList);                          // page list를 전송
//            model.addAttribute("paging", service.paging(pageable));         // 페이지 번호를 위한 list
//            model.addAttribute("page", service.checkPageable(pageable));    // 현재 페이지 정보 detail에 전달용
//            model.addAttribute("lastPageNumber", service.boardListLastPage(pageable.getPageSize()) -1);   // 마지막 페이지 확인용
////        }
////        else {
////        }
//
//        model.addAttribute("search", search);
//
//        return "board/list";
//    }
//
//    @GetMapping("/detail")
//    public String detail(@RequestParam("id") Long id,
//                         @RequestParam("size") int size,
//                         Model model) {
//
//        Board board = service.findById(id);
//        model.addAttribute("board", board);
//
//        model.addAttribute("boardNext", service.findById(id+1));        // 다음 글
//        model.addAttribute("boardPrev", service.findById(id-1));        // 이전 글
//
//        // 목록으로
//        model.addAttribute("page", service.returnPageNumber(id, size));
//        model.addAttribute("size", size);
//
//        // 댓글 테스트
//        Map<String, String> testMap = new HashMap<>();
//
//        testMap.put("registeredAt", "2021-09-01 12:00");
//        testMap.put("comment", "테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 테스트 내용입니다 ");
//        testMap.put("nickname", "멍청한비둘기들");
//
//        model.addAttribute("comment", testMap);
//
//        return "board/detail";
//    }
//}
