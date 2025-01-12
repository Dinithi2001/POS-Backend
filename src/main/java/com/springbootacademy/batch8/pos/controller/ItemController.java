package com.springbootacademy.batch8.pos.controller;

import com.springbootacademy.batch8.pos.dto.ItemSaveRequestDTO;
import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch8.pos.service.ItemService;
import com.springbootacademy.batch8.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping(
//            path = {"/save"}
//    )
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
//        itemService.saveItem(itemSaveRequestDTO);
//        return "Saved";
//    }

    @PostMapping(
            path = {"/save"}
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        //ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
        //        new StandardResponse(201,"success",message), HttpStatus.CREATED
        //);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = {"/get-by-name"},
            params = "name"
    )

    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam (value = "name")String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(
            path = {"/get-by-name-with-mapstruct"},
            params = "name"
    )

    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam (value = "name")String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemDTOS;
    }
}
