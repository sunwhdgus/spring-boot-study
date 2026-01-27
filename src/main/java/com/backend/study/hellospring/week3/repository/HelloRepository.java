package com.backend.study.hellospring.week3.repository;

import com.backend.study.hellospring.week3.web.dto.HelloResponseDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HelloRepository {
    // 1. DB 대신 데이터를 저장할 메모리 공간 (자바의 Map 사용)
    private static Map<Long, HelloResponseDto> store = new HashMap<>();
    private static long sequence = 0L;

    // 2. 데이터 저장하기
    public HelloResponseDto save(String name, int amount) {
        HelloResponseDto data = new HelloResponseDto(name, amount);
        sequence++;
        store.put(sequence, data);
        return data;
    }

    // 3. 데이터 조회하기 (번호로 찾기)
    public HelloResponseDto findById(Long id) {
        return store.get(id);
    }

    // 4. 데이터 삭제하기
    public void delete(Long id) {
        store.remove(id);
    }

    // 5. 데이터 전체 조회
    public Map<Long, HelloResponseDto> findAll() {
        return store;
    }
}
