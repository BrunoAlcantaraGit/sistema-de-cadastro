package com.CRUD.sitema_de_cadastro.entity;

import lombok.Data;

@Data
public class EnderecoRequest {
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
