package com.example.teamproject_advice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = {"user", "board"})
@Builder
@Accessors(chain = true)
public class Comment {

    @Id         // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_increment
    private Long id;

    private String comments;
    private LocalDateTime createdAt;
    private String createdBy;

    private LocalDateTime updatedAt;
    private String updatedBy;

    private LocalDateTime unregisteredAt;

    @ManyToOne // N : 1
    private Board board;
    @ManyToOne
    private User user;

}
