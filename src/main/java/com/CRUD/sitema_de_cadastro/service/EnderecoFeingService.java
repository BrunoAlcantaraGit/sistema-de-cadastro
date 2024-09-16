package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.enderecoFeing.EnderecoFeing;
import com.CRUD.sitema_de_cadastro.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class EnderecoFeingService {
    EnderecoFeing enderecoFeing;
    public Endereco buscarEnderecoApi( String cep) {
        return  enderecoFeing.enderecoApi(cep);
    }
}



