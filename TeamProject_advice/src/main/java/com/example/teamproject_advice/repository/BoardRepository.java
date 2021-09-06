package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// 역할 : DB를 정의된 class의 규격으로 읽음
// JpaRepository<이름, PK 타입>
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String title);
//    public List<Board> findByIdLessThanAndIdGreaterThanEqualOrderByIdDesc(Long t, Long f);
//
//    public List<Board> findByTitleContainingOrderByIdDesc(String title);
//
//    public List<Board> findByUserContainingOrderByIdDesc(User user);

//    public List<Board> findByCreatedAt
}
