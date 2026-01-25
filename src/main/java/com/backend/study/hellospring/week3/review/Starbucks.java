package com.backend.study.hellospring.week3.review;

import org.springframework.stereotype.Component;

@Component
public class Starbucks implements CoffeeMachine {
    @Override
    public String makeCoffee() {
        return "스타벅스 아메리카노 (5000원)";
    }
}
