package com.backend.study.hellospring.week3.web;

import com.backend.study.hellospring.week3.service.HelloService;
import com.backend.study.hellospring.week3.web.dto.HelloResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService; // Service 소환

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return helloService.save(name, amount);
    }

    @DeleteMapping("/hello/dto/{id}")
    public String delete(@PathVariable Long id) {
        helloService.delete(id);
        return id + "번 데이터가 삭제되었습니다.";
    }
}
