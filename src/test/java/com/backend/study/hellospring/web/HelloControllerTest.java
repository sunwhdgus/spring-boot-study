package com.backend.study.hellospring.web;

import com.backend.study.hellospring.week3.service.HelloService;
import com.backend.study.hellospring.week3.web.HelloController;
import com.backend.study.hellospring.week3.web.dto.HelloResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloService helloService;

    @Test
    @DisplayName("hello가 리턴된다")
    void hello() throws Exception {
        String hello = "Hello World!";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @DisplayName("helloDto가 리턴된다")
    void helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        given(helloService.save(name, amount))
                .willReturn(new HelloResponseDto(name, amount));

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount)); // 여기가 핵심 수정! (.value 사용)
    }

    @Test
    public void delete_test() throws Exception {
        Long deletedId = 1L;

        mvc.perform(delete("/hello/dto/" + deletedId))
                .andExpect(status().isOk())
                .andExpect(content().string(deletedId + "번 데이터가 삭제되었습니다."));
    }
}