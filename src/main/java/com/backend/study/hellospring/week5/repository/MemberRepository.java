package com.backend.study.hellospring.week5.repository;

import com.backend.study.hellospring.week5.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
