package com.example.vincle_ej2.entity;

import com.example.vincle_ej2.enums.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String timestamp;
    protected String nameClient;

    protected EnumTiposItem enumTipoItem;
    protected EnumEstado enumEstado;
    protected EnumCapacidad enumCapacidad;
    protected EnumEnvase enumEnvase;
    protected EnumNevera enumNevera;



}
