package com.backend.study.hellospring.domain.member.service;

import com.backend.study.hellospring.domain.member.dto.SignupRequestDto;
import com.backend.study.hellospring.domain.member.entity.Member;
import com.backend.study.hellospring.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; // 암호화

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String nickname = requestDto.getNickname();

        // 1. 중복 아이디 검사
        if (memberRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // 2. 회원 객체 생성 (기본 권한은 ROLE_USER)
        Member member = new Member(username, password, nickname);

        // 3. DB 저장
        memberRepository.save(member);
    }
}
