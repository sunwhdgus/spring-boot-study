package com.backend.study.hellospring.service;

import com.backend.study.hellospring.repository.HelloRepository;
import com.backend.study.hellospring.web.dto.HelloResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 서비스 명찰 달기
@RequiredArgsConstructor // repository 자동 연결하기 (생성자 주입)
public class HelloService {
    private final HelloRepository helloRepository; // repository 불러오기

    // 주문 받아서 저장하라고 시키기
    public HelloResponseDto save(String name, int amount) {
        return helloRepository.save(name, amount);
    }

    // 번호로 물건 찾아오라고 시키기
    public HelloResponseDto findById(Long id) {
        return helloRepository.findById(id);
    }
}
