package com.backend.study.hellospring.domain.item.controller;

import com.backend.study.hellospring.domain.item.dto.ItemRequestDto;
import com.backend.study.hellospring.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public String createItem(@RequestBody ItemRequestDto requestDto) {
        itemService.saveItem(requestDto);
        return "상품 등록 완료";
    }
}
