package com.springbootacademy.batch8.pos.service;

import com.springbootacademy.batch8.pos.dto.ItemSaveRequestDTO;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
