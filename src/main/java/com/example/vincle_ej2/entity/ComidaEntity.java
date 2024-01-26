package com.example.vincle_ej2.entity;

import com.example.vincle_ej2.enums.*;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ComidaEntity extends ItemEntity {
    public ComidaEntity() {
        super();
    }
    @Builder
    public ComidaEntity(Integer id, String timestamp, String nameClient,
                        EnumEstado enumEstado, EnumCapacidad enumCapacidad, EnumEnvase enumEnvase, EnumNevera enumNevera) {
        super(id, timestamp, nameClient, EnumTiposItem.COMIDA, enumEstado, enumCapacidad, enumEnvase, enumNevera);
    }
}
