package com.example.teamproject_advice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = {"user", "board"})
public class BoardComment {

    @Id         // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_increment
    private Long id;

    private String comment;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    private LocalDateTime unregisteredAt;

    @ManyToOne
    private Board board;
    @ManyToOne
    private User user;
}
