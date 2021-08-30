package com.example.teamproject_advice.controller;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.service.implement.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @GetMapping("/test")
    public String test(Model model) {
        List<Board> boardList = service.boardList();

        model.addAttribute("list", boardList);
        return "board/list";
    }


}
