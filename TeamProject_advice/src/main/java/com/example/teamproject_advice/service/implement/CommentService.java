//package com.example.teamproject_advice.service.implement;
//
//import com.example.teamproject_advice.model.entity.Board;
//import com.example.teamproject_advice.model.entity.Comment;
//import com.example.teamproject_advice.model.entity.User;
//import com.example.teamproject_advice.repository.CommentRepository;
//import com.example.teamproject_advice.repository.BoardRepository;
//import com.example.teamproject_advice.repository.UserRepository;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Transactional
//@RequiredArgsConstructor
//@Service
//public class CommentService {
//
//    @NonNull
//    private BoardRepository boardrepository;
//    @NonNull
//    private CommentRepository commentRepository;
//    @NonNull
//    private UserRepository userRepository;
//
//    // 댓글 등록하기
//    public Comment createComment(Comment comment, User user, long board) {
//        Optional<Board> board1 = this.boardrepository.findById(board);
//        board1.ifPresent(co -> {
//            comment.changeBoard(co);
//        });
//        comment.changeAuthor(user);
//        return this.commentRepository.save(comment);
//    }
//
//    // 댓글 리스트?
//    @Transactional(readOnly = true)
//    public List<Comment> ListBoardComment(long board) {
//        return this.commentRepository.getBoardCommentOfBoard(board);
//    }
//
//    // 댓글 삭제
//    @Transactional
//    public List<Comment> DeleteBoardComment(long commentNo, long board) {
//        this.commentRepository.deleteById(commentNo);
//        return this.commentRepository.getBoardCommentOfBoard(board);
//    }
//
//    // 댓글 수정
//    @Transactional
//    public List<Comment> ModifyComments(Comment comment, long commentNo, long board) {
//        Optional<Comment> modifycomment = this.commentRepository.findById(commentNo);
//        modifycomment.ifPresent(origin -> {
//            origin.setComment(comment.getComment());
//            this.commentRepository.save(origin);
//        });
//
//        return this.commentRepository.getBoardCommentOfBoard(board);
//    }
//}
//
//
