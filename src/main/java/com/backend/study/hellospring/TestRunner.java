package com.backend.study.hellospring;

import com.backend.study.hellospring.week5.entity.Member;
import com.backend.study.hellospring.week5.entity.Product;
import com.backend.study.hellospring.week5.repository.MemberRepository;
import com.backend.study.hellospring.week5.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired MemberRepository memberRepository;
    @Autowired ProductRepository productRepository;

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // 1. 화원 만들기 (철수)
        Member member1 = new Member();
        member1.setName("철수");
        memberRepository.save(member1); // DB 저장

        // 2. 상품 만들기 (철수가 커피를 삼)
        Product product1 = new Product();
        product1.setName("아이스 아메리카노");
        product1.setPrice(4500);
        product1.setMember(member1); // 커피 주인은 철수
        productRepository.save(product1);

        // 3. 상품 하나 더 (철수가 케이크도 샀음)
        Product product2 = new Product();
        product2.setName("치즈 케이크");
        product2.setPrice(6000);
        product2.setMember(member1);
        productRepository.save(product2);

        System.out.println("기본 데이터 세팅 완료");

        /*
        // 4. 기억 지우기 (DB에서 진짜로 가져오는지 확인)
        em.clear();
        System.out.println("======================================");
        System.out.println(" 캐시를 비웠습니다. 이제 DB에서 다시 찾아옵니다!");
        System.out.println("======================================");

        // 5. 조회 실험 (Eager 확인 구간)
        System.out.println(">>>>>> ️ [" + member1.getName() + "] 님의 정보를 DB에서 가져옵니다... <<<<<<");

        // 여기서 쿼리가 어떻게 나가는가 확인
        Member foundMember = memberRepository.findById(member1.getId()).get();

        System.out.println("찾은 사람: " + foundMember.getName());

        // 상품 목록 확인
        List<Product> buyingList = foundMember.getProducts();
        System.out.println("구매한 상품 개수: " + buyingList.size() + "개");

        // for 문으로 상품 이름도 출력
        for (Product p : buyingList) {
            System.out.println(" - 구매 품목: " + p.getName() + " (" + p.getPrice() + "원)");
        }
        System.out.println("======================================");
        */
    }
}
