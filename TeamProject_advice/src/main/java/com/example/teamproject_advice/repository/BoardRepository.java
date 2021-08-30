package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.model.entity.Board;
import com.example.teamproject_advice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

//    public List<Board> findByIdGreaterThanOrderByIdDesc(Long id);
//
//    public List<Board> findByTitleContainingOrderByIdDesc(String title);
//
//    public List<Board> findByUserContainingOrderByIdDesc(User user);

//    public List<Board> findByCreatedAt
}
