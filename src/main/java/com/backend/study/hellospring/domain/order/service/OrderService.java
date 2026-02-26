package com.backend.study.hellospring.domain.order.service;

import com.backend.study.hellospring.domain.item.entity.Item;
import com.backend.study.hellospring.domain.item.repository.ItemRepository;
import com.backend.study.hellospring.domain.member.entity.Member;
import com.backend.study.hellospring.domain.member.repository.MemberRepository;
import com.backend.study.hellospring.domain.order.dto.OrderRequestDto;
import com.backend.study.hellospring.domain.order.entity.Order;
import com.backend.study.hellospring.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void order(OrderRequestDto dto) {
        // 1. 회원 조회
        Member member = memberRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));

        // 2. 상품 조회
        Item item = itemRepository.findById(dto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));

        // 3. 주문 생성 (이때 재고 줄어듦)
        Order order = new Order(member, item, dto.getCount());

        // 4. 저장
        orderRepository.save(order);
    }
}
