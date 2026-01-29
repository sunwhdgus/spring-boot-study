package com.backend.study.hellospring.week4.dto;

public class ErrorDetails {
    private String message; // 에러 메시지 담을 변수

    // 1. 기본 생성자
    public ErrorDetails() {
    }

    // 2. 메시지를 바로 담는 생성자 (편의용)
    public ErrorDetails(String message) {
        this.message = message;
    }

    // 3. Getter & Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
