package com.backend.study.hellospring.domain.member.controller;

import com.backend.study.hellospring.domain.member.dto.SignupRequestDto;
import com.backend.study.hellospring.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDto requestDto) {
        memberService.signup(requestDto);
        return "회원가입 성공";
    }
}
