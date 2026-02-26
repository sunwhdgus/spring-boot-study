package com.backend.study.hellospring.domain.board.controller;

import com.backend.study.hellospring.domain.board.dto.BoardRequestDto;
import com.backend.study.hellospring.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public String writeBoard(@RequestBody BoardRequestDto requestDto) {
        boardService.writeBoard(requestDto);
        return "게시글 작성 완료";
    }
}
