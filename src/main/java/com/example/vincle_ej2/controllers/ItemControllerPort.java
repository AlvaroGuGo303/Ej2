package com.example.vincle_ej2.controllers;

import com.example.vincle_ej2.dto.ItemDTO;
import com.example.vincle_ej2.valueObject.ResponseDTO;
import org.springframework.web.bind.annotation.*;

public interface ItemControllerPort {

    @PostMapping("/createItemRandom")
    ResponseDTO<Object> createItemRandom (@RequestBody String nameClient);

    @PostMapping("/createBebidaRandom")
    ResponseDTO<Object> createBebidaRandom (@RequestBody String nameClient);

    @PostMapping("/createComidaRandom")
    ResponseDTO<Object> createComidaRandom (@RequestBody String nameClient);

    @PostMapping("/createSalsasRandom")
    ResponseDTO<Object> createSalsasRandom (@RequestBody String nameClient);

    @PostMapping("/createEspeciesRandom")
    ResponseDTO<Object> createEspeciesRandom (@RequestBody String nameClient);

    @GetMapping("/get/{itemId}")
    ResponseDTO<Object> getItemById (@PathVariable("itemId") Integer itemId);

    @GetMapping("/getAll")
    ResponseDTO<Object> getAllItems ();

    @PutMapping("/update")
    ResponseDTO<Object> updateItem (@RequestBody ItemDTO itemDTO);

    @DeleteMapping("/delete/{itemId}")
    ResponseDTO<Object> deleteItemById (@PathVariable("itemId") Integer itemId);
}
