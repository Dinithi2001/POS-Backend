package com.springbootacademy.batch8.pos.service.impl;

import com.springbootacademy.batch8.pos.dto.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.entity.Item;
import com.springbootacademy.batch8.pos.entity.enums.MeasuringUnitType;
import com.springbootacademy.batch8.pos.repo.ItemRepo;
import com.springbootacademy.batch8.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

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
         if(itemRepo.existsById(item.getItem_id()) ){
             itemRepo.save(item);
             return item.getItem_id() + " Saved successfully";
         }else{
             throw new DuplicateKeyException("Already added");
         }

    }


}
