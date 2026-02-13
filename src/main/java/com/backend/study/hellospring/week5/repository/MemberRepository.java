package com.backend.study.hellospring.week5.repository;

import com.backend.study.hellospring.week5.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m join fetch m.products")
    List<Member> findAllFetchJoin();
}
