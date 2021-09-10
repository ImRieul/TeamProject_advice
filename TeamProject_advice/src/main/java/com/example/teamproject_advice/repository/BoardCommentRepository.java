package com.example.teamproject_advice.repository;

import com.example.teamproject_advice.model.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentRepository extends CrudRepository<BoardComment, Long> {

    @Query("SELECT c from BoardComment c where c.board.id=:board and c.id>0 order by c.id ASC")
    public List<BoardComment> getBoardCommentOfBoard(@Param("board") Long board);
}
