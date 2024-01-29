package com.example.vincle_ej2.repository;

import com.example.vincle_ej2.body.ItemBody;
import com.example.vincle_ej2.entity.*;
import com.example.vincle_ej2.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class SqlItemRepositoryImp {

    private final SqlItemRepository sqlItemRepository;

    @Autowired
    public SqlItemRepositoryImp(SqlItemRepository sqlItemRepository) {
        this.sqlItemRepository = sqlItemRepository;
    }

    public ItemEntity createItemRandom(String nameClient, EnumTiposItem randomTipoItem){
        Random random = new Random();

        if(randomTipoItem==null){
            EnumTiposItem[] tiposItems = EnumTiposItem.values();
            int randomIndexTipoItem = random.nextInt(tiposItems.length);
            randomTipoItem = tiposItems[randomIndexTipoItem];
        }

        /*
        EnumEstado[] estados = EnumEstado.values();
        int randomIndexEstado = random.nextInt(estados.length);
        EnumEstado randomEstado = estados[randomIndexEstado];
        */
        EnumEstado estadoCreated  = EnumEstado.ESTADO_CREATED;

        EnumCapacidad[] capacidades = EnumCapacidad.values();
        int randomIndexCapacidad = random.nextInt(capacidades.length);
        EnumCapacidad randomCapacidad = capacidades[randomIndexCapacidad];

        EnumEnvase[] envases = EnumEnvase.values();
        int randomIndexEnvase = random.nextInt(envases.length);
        EnumEnvase randomEnvase = envases[randomIndexEnvase];

        EnumNevera[] neveras = EnumNevera.values();
        int randomIndexNevera = random.nextInt(neveras.length);
        EnumNevera randomNevera = neveras[randomIndexNevera];

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        if(randomTipoItem==EnumTiposItem.BEBIDA){
            BebidaEntity bebidaEntity = BebidaEntity.builder()
                    .nameClient(nameClient)
                    .timestamp(timestamp)
                    .enumEstado(estadoCreated)
                    .enumCapacidad(randomCapacidad)
                    .enumEnvase(randomEnvase)
                    .enumNevera(randomNevera)
                    .build();
            return this.sqlItemRepository.save(Objects.requireNonNull(bebidaEntity));

        }else if(randomTipoItem==EnumTiposItem.COMIDA){
            ComidaEntity comidaEntity = ComidaEntity.builder()
                    .nameClient(nameClient)
                    .timestamp(timestamp)
                    .enumEstado(estadoCreated)
                    .enumCapacidad(randomCapacidad)
                    .enumEnvase(randomEnvase)
                    .enumNevera(randomNevera)
                    .build();
            return this.sqlItemRepository.save(Objects.requireNonNull(comidaEntity));

        }else if(randomTipoItem==EnumTiposItem.SALSAS){
            SalsasEntity salsasEntity = SalsasEntity.builder()
                    .nameClient(nameClient)
                    .timestamp(timestamp)
                    .enumEstado(estadoCreated)
                    .enumCapacidad(randomCapacidad)
                    .enumEnvase(randomEnvase)
                    .enumNevera(randomNevera)
                    .build();
            return this.sqlItemRepository.save(Objects.requireNonNull(salsasEntity));

        }else if(randomTipoItem==EnumTiposItem.ESPECIES){
            EspeciesEntity especiesEntity = EspeciesEntity.builder()
                    .nameClient(nameClient)
                    .timestamp(timestamp)
                    .enumEstado(estadoCreated)
                    .enumCapacidad(randomCapacidad)
                    .enumEnvase(randomEnvase)
                    .enumNevera(randomNevera)
                    .build();
            return this.sqlItemRepository.save(Objects.requireNonNull(especiesEntity));
        }

        return null;
    }

    public ItemEntity getItemById(Integer itemId) {
        return this.sqlItemRepository.findById(itemId).orElse(null);
    }

    public List<ItemEntity> getAllItems() {
        return this.sqlItemRepository.findAll();
    }

    public ItemEntity updateItem(ItemBody itemBody) {
        ItemEntity itemEntity = this.getItemById(itemBody.getId());
        // ¿Hay que verificar si está borrado?
        // ¿Se puede hacer el update de uno ya borrado? En teoría no, ¿o si? ¿Quién lo hace?
        if( itemEntity == null){  // || itemEntity.getEnumEstado()==EnumEstado.ESTADO_DELETED){
            return null;
        }
        itemEntity.setNameClient(itemBody.getNameClient());
        itemEntity.setEnumTipoItem(itemBody.getEnumTipoItem());
        itemEntity.setEnumEstado(EnumEstado.ESTADO_WAITING);
        itemEntity.setEnumCapacidad(itemBody.getEnumCapacidad());
        itemEntity.setEnumEnvase(itemBody.getEnumEnvase());
        itemEntity.setEnumNevera(itemBody.getEnumNevera());

        return this.sqlItemRepository.save(Objects.requireNonNull(itemEntity));
    }

    public ItemEntity deleteItemById(Integer itemId, String nameClient) {
        ItemEntity itemEntity = this.getItemById(itemId);
        if( itemEntity != null  && itemEntity.getEnumEstado()!=EnumEstado.ESTADO_DELETED){
            itemEntity.setEnumEstado(EnumEstado.ESTADO_DELETED);
            itemEntity.setNameClient(nameClient);
            this.sqlItemRepository.save(Objects.requireNonNull(itemEntity));
            return itemEntity;
        }
        return null;
    }

}
