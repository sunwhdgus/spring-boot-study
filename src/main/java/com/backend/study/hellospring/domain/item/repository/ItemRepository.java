package com.backend.study.hellospring.domain.item.repository;

import com.backend.study.hellospring.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // 기본 CRUD는 JpaRepository가 다 해줌
}
