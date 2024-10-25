package com.CRUD.sitema_de_cadastro.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String logradouro;
  private String numero;
  private String cep;
  private String bairro;
  private String uf;
  private String localidade;
  private  String ibge;
  //private Cliente cliente;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getIbge() {
    return ibge;
  }

  public void setIbge(String ibge) {
    this.ibge = ibge;
  }
}
