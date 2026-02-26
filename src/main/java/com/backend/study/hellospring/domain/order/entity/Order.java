package com.backend.study.hellospring.domain.order.entity;

import com.backend.study.hellospring.domain.item.entity.Item;
import com.backend.study.hellospring.domain.member.entity.Member;
import com.backend.study.hellospring.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders") // SQL 예약어 피하기 위해 테이블 이름 변경
@NoArgsConstructor
public class Order extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //회원 한 명이 여러 주문 가능
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) // 상품 하나가 여러 주문에 포함 가능 (단순화 버전)
    @JoinColumn(name = "item_id")
    private Item item;

    private int count; // 주문 수량

    // 생성자 (주문 생성 시 로직 포함)
    public Order(Member member, Item item, int count) {
        this.member = member;
        this.item = item;
        this.count = count;
        item.removeStock(count); // 주문하면 재고 깎기
    }
}
