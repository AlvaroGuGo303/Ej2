package com.example.vincle_ej2.entity;

import com.example.vincle_ej2.enums.*;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SalsasEntity extends ItemEntity {
    public SalsasEntity() {
        super();
    }

    @Builder
    public SalsasEntity(Integer id, String timestamp, String nameClient,
                        EnumEstado enumEstado, EnumCapacidad enumCapacidad, EnumEnvase enumEnvase, EnumNevera enumNevera) {
        super(id, timestamp, nameClient, EnumTiposItem.SALSAS,enumEstado, enumCapacidad, enumEnvase, enumNevera);
    }
}
