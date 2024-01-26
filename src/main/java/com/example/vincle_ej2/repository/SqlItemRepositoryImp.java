package com.example.vincle_ej2.repository;

import com.example.vincle_ej2.dto.ItemDTO;
import com.example.vincle_ej2.entity.*;
import com.example.vincle_ej2.enums.*;
import com.example.vincle_ej2.mapper.ItemMapper;
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

    public ItemEntity updateItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = ItemMapper.getInstance().EntityToDto(itemDTO);
        itemEntity.setEnumEstado(EnumEstado.ESTADO_WAITING);

        /*
         *Esto debería funcionar, pero da error en el ID.
         */
        //return this.sqlItemRepository.save(Objects.requireNonNull(itemEntity));

        /*
         * Haciéndolo manualmente, en caso de dejar de que no se quiera modificar un campo, se debería dejar vacío y actualizar lo necesario
         * Se necesita que el nombre de la variable sea exactamente igual al que está esperando, por eso creamos una variable y no pasamos el campo directamente
        */
        Integer id = itemEntity.getId();
        String timestamp = itemEntity.getTimestamp();
        String nameClient = itemEntity.getNameClient();
        EnumTiposItem enumTipoItem = itemEntity.getEnumTipoItem();
        EnumEstado enumEstado = itemEntity.getEnumEstado();
        EnumCapacidad enumCapacidad = itemEntity.getEnumCapacidad();
        EnumEnvase enumEnvase = itemEntity.getEnumEnvase();
        EnumNevera enumNevera = itemEntity.getEnumNevera();
        Integer resuInteger = this.sqlItemRepository.updateFullItemParams(
                id,timestamp, nameClient,
                enumTipoItem,enumEstado,enumCapacidad,enumEnvase,enumNevera);
        // If okk -> integer = num rows affected. 0 if no changes. -1 if error.
        if(resuInteger != -1){
            return itemEntity;
        }
        return null;
    }

    public ItemEntity deleteItemById(Integer itemId) {
        ItemEntity itemEntity = this.getItemById(itemId);
        if( itemEntity != null){
            itemEntity.setEnumEstado(EnumEstado.ESTADO_DELETED);
            this.sqlItemRepository.save(Objects.requireNonNull(itemEntity));
            return itemEntity;
        }
        return null;
    }

}
