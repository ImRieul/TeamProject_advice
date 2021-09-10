package com.example.teamproject_advice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "BOARD_COMMENT")
@Data
@Builder
@ToString(exclude = {"user", "board"})
@Accessors(chain = true)
public class BoardComment {

    @Id         // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_increment
    private Long id;

    @NonNull
    private String comment;

    private LocalDateTime createdAt;

    @NonNull
    private String createdBy;

    private LocalDateTime updatedAt;
    private String updatedBy;

    private LocalDateTime unregisteredAt;

//    @ManyToOne // N : 1
//    private Board board;
//    @ManyToOne
//    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    //User엔티티와  Board엔티티를 연결하는 함수?
    public void changeAuthor(User author) {
        this.user = author;
    }
    public void changeBoard(Board board) {
        this.board = board;
    }
}
