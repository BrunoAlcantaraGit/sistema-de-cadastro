package com.CRUD.sitema_de_cadastro.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 7)
    private String placa;
    @Column (length = 11)
    private  String renavan;
    private String tipoRodado;

}
