package com.springbootacademy.batch8.pos.controller;

import com.springbootacademy.batch8.pos.dto.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = {"/save"}
    )
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        itemService.saveItem(itemSaveRequestDTO);
        return "Saved";
    }
}
