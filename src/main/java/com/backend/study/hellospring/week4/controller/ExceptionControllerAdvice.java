package com.backend.study.hellospring.week4.controller;

import com.backend.study.hellospring.week4.dto.ErrorDetails;
import com.backend.study.hellospring.week4.exception.NotEnoughMoneyException;
import com.backend.study.hellospring.week4.exception.PaymentValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    // 낚아챌 에러: NotEnoughMoneyException
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {

        // 1. 에러 내용을 담을 상자(ErrorDetails) 만들기
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("지불할 돈이 부족합니다! (Not enough money)");

        // 2. 400 에러(Bad Request)와 함께 상자 리턴
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(PaymentValidationException.class)
    public ResponseEntity<ErrorDetails> paymentValidationHandler(PaymentValidationException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
