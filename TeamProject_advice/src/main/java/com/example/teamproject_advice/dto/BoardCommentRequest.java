package com.example.teamproject_advice.dto;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardCommentRequest {

    @NotNull
    private String Comment;

    @NotNull
    private Long User;

    private Long Account;

    @NotNull
    private Long Board;

    private Long Title;

    @NotNull
    private String Created_by;
}