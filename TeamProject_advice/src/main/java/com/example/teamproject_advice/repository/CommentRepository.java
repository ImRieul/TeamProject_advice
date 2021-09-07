package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 역할 : DB를 정의된 class의 규격으로 읽음
// JpaRepository<이름, PK 타입>
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByBoard(Board board, Pageable pageable);

}
