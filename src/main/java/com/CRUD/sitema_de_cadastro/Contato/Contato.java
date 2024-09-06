package com.CRUD.sitema_de_cadastro.Contato;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contato {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String dd;
private String numeroTelefone;

}
