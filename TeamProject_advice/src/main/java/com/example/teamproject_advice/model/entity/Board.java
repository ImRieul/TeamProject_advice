package com.example.teamproject_advice.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = {"user","boardCommentList"})
@Builder
@Accessors(chain = true)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Long writer;

    private LocalDateTime registeredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    @ManyToOne      // N : 1
    private User user;

    // board : BoardComment > 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    private List<BoardComment> boardCommentList;
}
