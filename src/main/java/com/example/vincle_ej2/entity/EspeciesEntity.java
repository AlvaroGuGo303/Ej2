package com.example.vincle_ej2.entity;

import com.example.vincle_ej2.enums.*;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class EspeciesEntity extends ItemEntity {
    public EspeciesEntity() {
        super();
    }

    @Builder
    public EspeciesEntity(Integer id, String timestamp, String nameClient,
                          EnumEstado enumEstado, EnumCapacidad enumCapacidad, EnumEnvase enumEnvase, EnumNevera enumNevera) {
        super(id, timestamp, nameClient, EnumTiposItem.ESPECIES,enumEstado, enumCapacidad, enumEnvase, enumNevera);
    }
}
