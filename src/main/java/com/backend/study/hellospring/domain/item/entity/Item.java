package com.backend.study.hellospring.domain.item.entity;

import com.backend.study.hellospring.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseEntity { //BaseEntity 상속해서 생성시간 자동관리

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 상품명
    private int price; // 가격
    private int stockQuantity; // 재고수량
    private String detail; // 상세설명

    // 상품 등록용 생성자
    public Item(String name, int price, int stockQuantity, String detail) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.detail = detail;
    }

    // 비즈니스 로직: 재고 감소 (주문 시 필요!)
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stockQuantity = restStock;
    }
}
