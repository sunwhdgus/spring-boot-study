package com.backend.study.hellospring.week3.review;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
@Primary
public class MegaCoffee implements CoffeeMachine {
    public MegaCoffee() {
        System.out.println(">>> 메가커피 머신 빈 생성됨! (싱글톤이라 딱 한 번만 뜸)");
    }

    @Override
    public String makeCoffee() {
        return "메가커피 아메리카노 (4500원)";
    }
}
