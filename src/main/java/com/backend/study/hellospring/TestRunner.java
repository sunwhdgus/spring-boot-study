package com.backend.study.hellospring;

import com.backend.study.hellospring.week5.entity.Member;
import com.backend.study.hellospring.week5.entity.Product;
import com.backend.study.hellospring.week5.repository.MemberRepository;
import com.backend.study.hellospring.week5.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired MemberRepository memberRepository;
    @Autowired ProductRepository productRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // 1. 데이터 준비
        Member member1 = new Member();
        member1.setName("철수");
        memberRepository.save(member1); // DB 저장

        Product product1 = new Product();
        product1.setName("아이스 아메리카노");
        product1.setPrice(4500);
        product1.setMember(member1); // 커피 주인은 철수
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("치즈 케이크");
        product2.setPrice(6000);
        product2.setMember(member1);
        productRepository.save(product2);

        Member member2 = new Member();
        member2.setName("영희");
        memberRepository.save(member2);

        Product product3 = new Product();
        product3.setName("라떼");
        product3.setPrice(5000);
        product3.setMember(member2);
        productRepository.save(product3);

        Member member3 = new Member();
        member3.setName("맹구");
        memberRepository.save(member3);

        Product product4 = new Product();
        product4.setName("프라푸치노");
        product4.setPrice(6000);
        product4.setMember(member3);
        productRepository.save(product4);

        System.out.println("기본 데이터 세팅 완료");

        /*

        System.out.println("======================================");
        System.out.println("[N+1 문제 실험 시작]");
        System.out.println("======================================");

        // 1. 모든 회원 조회
        Iterable<Member> members = memberRepository.findAll();

        System.out.println(">>>>>> [반복문 시작] 상품 이름을 확인합니다! <<<<<<");

        // 2. 회원들의 상품 목록 개수 확인
        for (Member m : members) {
            System.out.println("--------------------------------------");
            System.out.println("회원 이름: " + m.getName());
            System.out.println("주문한 상품 수: " + m.getProducts().size() + "개");
        }

        System.out.println("======================================");

        */

        System.out.println("======================================");
        System.out.println("[해결책 적용] Fetch Join으로 조회");
        System.out.println("======================================");

        List<Member> members = memberRepository.findAllFetchJoin();

        System.out.println(">>>>>> [반복문 시작] <<<<<<");

        for (Member m : members) {
            System.out.println("--------------------------------------");
            System.out.println("회원 이름: " + m.getName());
            System.out.println("주문한 상품 수: " + m.getProducts().size() + "개");

            int totalPrice = 0;
            for (Product p : m.getProducts()) {
                System.out.println("메뉴: " + p.getName() + " (" + p.getPrice() + "원)");
                totalPrice += p.getPrice();
            }
            System.out.println("총 주문 금액: " + totalPrice + "원");
        }
        System.out.println("======================================");
    }
}
