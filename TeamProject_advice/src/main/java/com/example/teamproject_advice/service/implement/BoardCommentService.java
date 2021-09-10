package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.BoardComment;
import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.BoardCommentRepository;
import com.example.teamproject_advice.repository.BoardRepository;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.interfaces.BoardCommentServiceInterface;
import com.example.teamproject_advice.service.interfaces.BoardServiceInterface;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardCommentService {

    @NonNull
    private BoardRepository boardrepository;
    @NonNull
    private BoardCommentRepository boardCommentRepository;
    @NonNull
    private UserRepository userRepository;

    // 댓글 등록하기
    public BoardComment createComment(BoardComment boardComment, User user, long board) {
        Optional<Board> board1 = this.boardrepository.findById(board);
        board1.ifPresent(co -> {
            boardComment.changeBoard(co);
        });
        boardComment.changeAuthor(user);
        return this.boardCommentRepository.save(boardComment);
    }

    // 댓글 리스트?
    @Transactional(readOnly = true)
    public List<BoardComment> ListBoardComment(long board) {
        return this.boardCommentRepository.getBoardCommentOfBoard(board);
    }

    // 댓글 삭제
    @Transactional
    public List<BoardComment> DeleteBoardComment(long commentNo,long board) {
        this.boardCommentRepository.deleteById(commentNo);
        return this.boardCommentRepository.getBoardCommentOfBoard(board);
    }

    // 댓글 수정
    @Transactional
    public List<BoardComment> ModifyComments(BoardComment boardComment, long commentNo, long board) {
        Optional<BoardComment> modifycomment = this.boardCommentRepository.findById(commentNo);
        modifycomment.ifPresent(origin -> {
            origin.setComment(boardComment.getComment());
            this.boardCommentRepository.save(origin);
        });

        return this.boardCommentRepository.getBoardCommentOfBoard(board);
    }
}


