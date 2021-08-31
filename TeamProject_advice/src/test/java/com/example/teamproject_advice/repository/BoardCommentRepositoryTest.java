//package com.example.teamproject_advice.repository;
//
//import com.example.teamproject_advice.TeamProjectAdviceApplicationTests;
//import com.example.teamproject_advice.model.entity.BoardComment;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class BoardCommentRepositoryTest extends TeamProjectAdviceApplicationTests {
//
//    @Autowired
//    private BoardCommentRepository boardCommentRepository;
//
//    @Test //생성
//    public void create() {
//        BoardComment comm1 = new BoardComment();
//        comm1.setComment("ready");
//
//        comm1.setCreatedAt(LocalDateTime.now());
//        comm1.setCreatedBy("admin");
//
//        comm1.setBoardId(1L);
//        comm1.setUserId(1L);
//
//
//        BoardComment newBoardComment = boardCommentRepository.save(comm1);
//        System.out.println(newBoardComment);
//    }
//
//    @Test //읽기
//    public void read() {
//
//        List<BoardComment> boardCommentsList = boardCommentRepository.findAll();
//
//        for (BoardComment boardComment : boardCommentList) {
//
//            System.out.println(item.getId());
//            System.out.println(item.getStatus());
//            System.out.println(item.getName());
//            System.out.println(item.getTitle());
//            System.out.println(item.getContent());
//            System.out.println(item.getPrice());
//            System.out.println(item.getBrand_name());
//            System.out.println(item.getBrand_name());
//        }
//    }
//
////    @Test //수정
////    public void update() {
////        Optional<User> user = userRepository.findById(2L);
////
////        user.ifPresent(u -> {
////            u.setAccount("jy");
////            u.setPassword("1234");
////            u.setUpdatedAt(LocalDateTime.now());
////            u.setUpdatedBy("admin");
////
////            userRepository.save(u);
////
////        });
////
////    }
////
////    @Test //삭제
////    public void delete() {
////        Optional<User> user = userRepository.findById(2L);
////
////        user.ifPresent(u -> {
////            userRepository.delete(u);
////        });
////    }
//}