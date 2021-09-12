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
    public Page<Comment> commentListPage(Pageable pageable) {
        int lastPage = commentListLastPage(pageable.getPageSize(), null);
        int valPage = pageable.getPageNumber();

        Pageable setPageable = (valPage > lastPage)? checkPageable( PageRequest.of(lastPage, pageSize, Sort.Direction.ASC, "id" ) ) : checkPageable( pageable );
        return commentRepository.findAll(setPageable);
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
        return null;
    }

    // url에 pageable이 입력되어 있는지 확인하는 메서드.
    @Override
    public Pageable checkPageable(Pageable pageable) {
        return (pageable.getSort() != Sort.unsorted())? pageable : PageRequest.of(0, pageSize, Sort.Direction.ASC, "id");
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public List<Integer> paging(Pageable pageable, int totalPage) {
        return null;
    }

    @Override
    public int commentListLastPage(int size, String search) {
        Pageable pageable = PageRequest.of(0, size, Sort.Direction.ASC);
        Page<Comment> page = ( search == null )? commentRepository.findAll(pageable) : commentRepository.findByCommentContaining(search, pageable);
        return page.getTotalPages() -1;
    }

    @Override
    public int returnPageNumber(Long id, int size) {
        return 0;
    }
}
