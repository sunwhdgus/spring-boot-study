package com.backend.study.hellospring.week3.review;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CafeMain {
    public static void main(String[] args) {
        // 1. 스프링 컨텍스트 실행
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CafeMain.class);

        // 2. 바리스타 빈 꺼내오기
        Barista barista1 = context.getBean(Barista.class);
        Barista barista2 = context.getBean(Barista.class);

        // 3. 커피 주문 (인터페이스 동작 확인)
        barista1.serve();

        //4. 싱글톤 확인
        System.out.println("barista1 == barista2 ? " + (barista1 == barista2));

        context.close();
    }
}
