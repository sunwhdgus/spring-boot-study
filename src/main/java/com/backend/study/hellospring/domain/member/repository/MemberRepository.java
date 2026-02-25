package com.backend.study.hellospring.domain.member.repository;

import com.backend.study.hellospring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //아이디로 회원 정보 찾기 (로그인, 중복 검사 때 사용)
    Optional<Member> findByUsername(String username);
}
