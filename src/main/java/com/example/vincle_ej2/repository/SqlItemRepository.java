package com.example.vincle_ej2.repository;

import com.example.vincle_ej2.entity.ItemEntity;
import com.example.vincle_ej2.enums.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlItemRepository extends JpaRepository<ItemEntity, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update item_entity set " +
            "timestamp = :timestamp, name_client = :nameClient, " +
            "enum_tipo_item = :enumTipoItem, enum_estado =  :enumEstado, enum_capacidad = :enumCapacidad, enum_envase = :enumEnvase, enum_nevera = :enumNevera " +
            "where id = (:id);", nativeQuery = true)
    Integer updateFullItemParams(
            @Param(value = "id") Integer id,
            @Param(value = "timestamp") String timestamp,
            @Param(value = "nameClient") String nameClient,
            @Param(value = "enumTipoItem") EnumTiposItem enumTipoItem,
            @Param(value = "enumEstado") EnumEstado enumEstado,
            @Param(value = "enumCapacidad") EnumCapacidad enumCapacidad,
            @Param(value = "enumEnvase") EnumEnvase enumEnvase,
            @Param(value = "enumNevera") EnumNevera enumNevera
    );

}
