package com.CRUD.sitema_de_cadastro.endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.swing.*;
@Data
@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Spring logradouro;
  private Spring bairro;
  private Spring uf;
  private Spring estado;

}
