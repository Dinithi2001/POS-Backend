package com.springbootacademy.batch8.pos.service;

import com.springbootacademy.batch8.pos.dto.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);
}
