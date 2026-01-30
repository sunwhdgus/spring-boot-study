package com.backend.study.hellospring.week4.exception;

public class PaymentValidationException extends RuntimeException{
    // 메시지를 우리가 직접 적어서 넘길 수 있게 생성자를 만듦
    public PaymentValidationException(String message) {
        super(message);
    }
}
