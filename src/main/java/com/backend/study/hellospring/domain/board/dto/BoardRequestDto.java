package com.backend.study.hellospring.domain.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto {
    private String username;
    private String title;
    private String content;
}
