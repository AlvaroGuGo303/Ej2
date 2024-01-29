package com.example.vincle_ej2.controllers;

import com.example.vincle_ej2.body.ItemBody;
import com.example.vincle_ej2.enums.EnumTiposItem;
import com.example.vincle_ej2.repository.SqlItemRepositoryImp;
import com.example.vincle_ej2.valueObject.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin
@Slf4j
public class ItemController implements ItemControllerPort{
    SqlItemRepositoryImp sqlItemRepositoryImp;

    @Autowired
    public ItemController(SqlItemRepositoryImp sqlItemRepositoryImp) {
        this.sqlItemRepositoryImp = sqlItemRepositoryImp;
    }

    @Override
    @PostMapping("/createItemRandom")
    public ResponseDTO<Object> createItemRandom (@RequestBody String nameClient){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setData(this.sqlItemRepositoryImp.createItemRandom(nameClient, null));
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @PostMapping("/createBebidaRandom")
    public ResponseDTO<Object> createBebidaRandom (@RequestBody String nameClient){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setData(this.sqlItemRepositoryImp.createItemRandom(nameClient,EnumTiposItem.BEBIDA));
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @PostMapping("/createComidaRandom")
    public ResponseDTO<Object> createComidaRandom (@RequestBody String nameClient){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setData(this.sqlItemRepositoryImp.createItemRandom(nameClient,EnumTiposItem.COMIDA));
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @PostMapping("/createSalsasRandom")
    public ResponseDTO<Object> createSalsasRandom (@RequestBody String nameClient){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setData(this.sqlItemRepositoryImp.createItemRandom(nameClient,EnumTiposItem.SALSAS));
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @PostMapping("/createEspeciesRandom")
    public ResponseDTO<Object> createEspeciesRandom (@RequestBody String nameClient){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setData(this.sqlItemRepositoryImp.createItemRandom(nameClient,EnumTiposItem.ESPECIES));
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @GetMapping("/get/{itemId}")
    public ResponseDTO<Object> getItemById (@PathVariable("itemId") Integer itemId){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            Object obj = this.sqlItemRepositoryImp.getItemById(itemId);
            if(obj != null){
                responseDTO.setData(obj);
            }else{
                responseDTO.setError("Invalid ID");
            }
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @GetMapping("/getAll")
    public ResponseDTO<Object> getAllItems (){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setData(this.sqlItemRepositoryImp.getAllItems());
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @PutMapping("/update")
    public ResponseDTO<Object> updateItem (@RequestBody ItemBody itemBody){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            Object obj = this.sqlItemRepositoryImp.updateItem(itemBody);
            if(obj != null){
                responseDTO.setData(obj);
            }else{
                responseDTO.setError("Invalid ID");
            }
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

    @Override
    @DeleteMapping("/delete/{itemId}")
    public ResponseDTO<Object> deleteItemById (@PathVariable("itemId") Integer itemId,@RequestBody String nameClient){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        try {
            Object obj = this.sqlItemRepositoryImp.deleteItemById(itemId,nameClient);
            if(obj != null){
                responseDTO.setData(obj);
            }else{
                responseDTO.setError("Invalid ID");
            }
        }catch (Exception e){
            responseDTO.setError("Exception: "+e.getMessage());
        }
        return responseDTO;
    }

}
