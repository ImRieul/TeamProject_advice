package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.Comment;
import com.example.teamproject_advice.repository.CommentRepository;
import com.example.teamproject_advice.service.interfaces.CommentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService implements CommentServiceInterface {

    private final BoardService boardService;
    private final CommentRepository commentRepository;
    private final int pageSize = 10;

    // 현재 페이지 출력
    @Override
    public Page<Comment> commentListPage(Board board, int page) {
        int lastPage = commentListLastPage(board,null);
        int choosePage = Math.min(page, lastPage);

        try {
            Pageable pageable = PageRequest.of(choosePage, pageSize, Sort.Direction.ASC, "id");
            return commentRepository.findByBoard(board, pageable);
        }
        catch (Exception e) {e.printStackTrace(); return null;}
    }



    @Override
    public void commentWrite(Long boardId, Long commentId, String content) {
        Board board = boardService.findById(boardId);
        Comment comment;

        // 댓글 생성
        if ( commentId == null ) {
            comment = Comment.builder()
                    .board(board)
                    .comment(content)
                    .createdAt(LocalDateTime.now())
                    .createdBy("user")
                    .registeredAt(LocalDateTime.now())
                    .user(board.getUser())
                    .build();
        }
        // 댓글 수정
        else {
            comment = findById(commentId);
            comment.setComment(content)
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy("user");
        }

        commentRepository.save(comment);
    }

    @Override
    public String commentDelete(Long id) {
        try {
            if ( id != null ) {
                commentRepository.delete(findById(id));
                return "success";
            }
            else { return "fail"; }
        } catch (Exception e) {e.printStackTrace(); return "error"; }

    }

    // url에 pageable이 입력되어 있는지 확인하는 메서드.
    @Override
    public Pageable checkPageable(Pageable pageable) {
        return (pageable.getSort() != Sort.unsorted())? pageable : PageRequest.of(0, pageSize, Sort.Direction.ASC, "id");
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Integer> paging(Pageable pageable, int totalPage) {
        return null;
    }

    @Override
    public int commentListLastPage(Board board, String search) {
        Pageable pageable = PageRequest.of(0, pageSize, Sort.Direction.ASC, "id");
        Page<Comment> page = ( search == null )? commentRepository.findByBoard(board, pageable) : commentRepository.findByCommentContaining(search, pageable);
        return page.getTotalPages() -1;
    }

    @Override
    public int returnPageNumber(Long id, int size) {
        return 0;
    }
}
