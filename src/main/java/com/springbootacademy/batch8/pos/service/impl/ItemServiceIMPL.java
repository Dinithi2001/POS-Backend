package com.springbootacademy.batch8.pos.service.impl;

import com.springbootacademy.batch8.pos.dto.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch8.pos.entity.Item;
import com.springbootacademy.batch8.pos.entity.enums.MeasuringUnitType;
import com.springbootacademy.batch8.pos.repo.ItemRepo;
import com.springbootacademy.batch8.pos.service.ItemService;
import com.springbootacademy.batch8.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSuplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );
//        itemRepo.save(item);
//        return item.getItemName();
     Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
         if(!itemRepo.existsById(item.getItem_id()) ){
             itemRepo.save(item);
             return item.getItem_id() + " Saved successfully";
         }else{
             throw new DuplicateKeyException("Already added");
         }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,true);

        if(items.size() > 0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else{
            throw new RuntimeException("Item is not active");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,true);

        if(items.size() > 0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else{
            throw new RuntimeException("Item is not active");
        }
    }


}
