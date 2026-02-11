package com.backend.study.hellospring.week5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 회원 한 명이 상품 여러 개를 가질 수 있음
    // DB에 저장하는 게 아니라 읽기 전용
    @OneToMany(mappedBy = "member")
    private List<Product> products = new ArrayList<>();
}
