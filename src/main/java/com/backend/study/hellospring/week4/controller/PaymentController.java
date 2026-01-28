package com.backend.study.hellospring.week4.controller;

import com.backend.study.hellospring.week4.domain.Payment;
import com.backend.study.hellospring.week4.dto.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    // 테스트 1: 그냥 객체 리턴해보기 (상태코드 200 0k 자동 설정)
    @GetMapping("/payment")
    public Payment getPayment() {
        // Payment 객체를 만들어서 그냥 던지면 알아서 JSON으로 변환됨
        return new Payment("p1001", 90000);
    }

    // 테스트 2: ResponseEntity 써보기 (상태코드, 헤더 직접 조작)
    @GetMapping("/payment-status")
    public ResponseEntity<Payment> getPaymentWithStatus() {
        Payment payment = new Payment("p1002", 50000);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Custom-Header", "Hello-Rest")
                .body(payment);
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest paymentDetails) {

        // 1. 서버 로그로 확인 (잘 받았는지 출력)
        System.out.println("결제 요청 금액: " + paymentDetails.getAmount());
        System.out.println("주문 번호: " + paymentDetails.getOrderId());

        // 2. 응답 보낼 객체 만들기 (받은 거 그대로 돌려주기)
        Payment response = new Payment();
        response.setAmount(paymentDetails.getAmount());
        response.setOrderId(paymentDetails.getOrderId());

        // 3. 상태코드 200(0k)과 함께 리턴
        return ResponseEntity
                .status(200)
                .body(response);
    }
}
