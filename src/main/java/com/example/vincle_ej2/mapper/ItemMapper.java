package com.example.vincle_ej2.mapper;

import com.example.vincle_ej2.dto.ItemDTO;
import com.example.vincle_ej2.entity.ItemEntity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ItemMapper implements Serializable {
    private static ItemMapper instance;

    public ItemMapper() {}

    public static ItemMapper getInstance() {
        if(instance==null){
            instance =new ItemMapper();
        }
        return instance;
    }

    public ItemEntity EntityToDto (ItemDTO itemDTO){
        if(itemDTO==null){
            return null;
        }
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        return new ItemEntity(
                itemDTO.getId(),
                timestamp,
                itemDTO.getNameClient(),
                itemDTO.getEnumTipoItem(),
                itemDTO.getEnumEstado(),
                itemDTO.getEnumCapacidad(),
                itemDTO.getEnumEnvase(),
                itemDTO.getEnumNevera()
                );
    }
}
