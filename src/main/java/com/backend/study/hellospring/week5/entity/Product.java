package com.backend.study.hellospring.week5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //Getter와 Setter (데이터를 넣고 빼기 위해 필요)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public Member getMember() { return member; }
    public void setMember(Member member) {this.member = member; }
}
