package com.springbootacademy.batch8.pos.util.mappers;

import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch8.pos.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
}
