package com.example.vincle_ej2.dto;

import com.example.vincle_ej2.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    protected Integer id;
    protected String nameClient;

    protected EnumTiposItem enumTipoItem;
    protected EnumEstado enumEstado;
    protected EnumCapacidad enumCapacidad;
    protected EnumEnvase enumEnvase;
    protected EnumNevera enumNevera;



}
