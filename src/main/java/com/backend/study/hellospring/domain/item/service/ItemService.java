package com.backend.study.hellospring.domain.item.service;

import com.backend.study.hellospring.domain.item.dto.ItemRequestDto;
import com.backend.study.hellospring.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(ItemRequestDto requestDto) {
        itemRepository.save(requestDto.toEntity());
    }
}
