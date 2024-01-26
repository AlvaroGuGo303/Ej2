package com.example.vincle_ej2.entity;

import com.example.vincle_ej2.enums.*;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class BebidaEntity extends ItemEntity {
    public BebidaEntity() {
        super();
    }
    @Builder
    public BebidaEntity(Integer id, String timestamp, String nameClient,
                        EnumEstado enumEstado, EnumCapacidad enumCapacidad, EnumEnvase enumEnvase, EnumNevera enumNevera) {
        super(id, timestamp, nameClient, EnumTiposItem.BEBIDA, enumEstado, enumCapacidad, enumEnvase, enumNevera);
    }
}
