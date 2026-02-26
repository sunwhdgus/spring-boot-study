package com.backend.study.hellospring.domain.board.service;

import com.backend.study.hellospring.domain.board.dto.BoardRequestDto;
import com.backend.study.hellospring.domain.board.entity.Board;
import com.backend.study.hellospring.domain.board.repository.BoardRepository;
import com.backend.study.hellospring.domain.member.entity.Member;
import com.backend.study.hellospring.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.IllegalChannelGroupException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void writeBoard(BoardRequestDto dto) {
        Member member = memberRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));

        Board board = new Board(dto.getTitle(), dto.getContent(), member);
        boardRepository.save(board);
    }
}
