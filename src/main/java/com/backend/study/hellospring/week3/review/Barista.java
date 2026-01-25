package com.backend.study.hellospring.week3.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Barista {

    private final CoffeeMachine coffeeMachine;

    @Autowired
    public Barista(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void serve() {
        System.out.println("주문하신 " + coffeeMachine.makeCoffee() + "나왔습니다!");
    }
}
