package com.backend.study.hellospring.week5.controller;

import com.backend.study.hellospring.week5.entity.Product;
import com.backend.study.hellospring.week5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 1. 컨트롤러 명찰 달기
public class ProductController {

    private final ProductService productService;

    // 2. 서비스랑 연결
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 3. 손님이 "/test" 라고 주문하면 실행되는 곳
    @GetMapping("/test")
    @ResponseBody // 화면 말고 글자로 보여줌
    public String test() {
        // 서비스한테 1번 상품 가져오라고 시키기
        Product product = productService.getProduct(1L);

        if (product != null) {
            return "상품명: " + product.getName() + ", 가격: " + product.getPrice();
        }
        else {
            return "상품이 없습니다. (DB를 확인해보세요)";
        }
    }
}
