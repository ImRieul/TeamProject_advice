package com.example.teamproject_advice.service.interfaces;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentServiceInterface {
    Page<Comment> commentListPage(Pageable pageable);
    void commentWrite(Long boardId, Long commentId, String content);

    String commentDelete(Long id);

    Pageable checkPageable(Pageable pageable);
    Comment findById(Long id);
    List<Integer> paging(Pageable pageable, int totalPage);

    int commentListLastPage(int size, String search);
    int returnPageNumber(Long id, int size);
}
