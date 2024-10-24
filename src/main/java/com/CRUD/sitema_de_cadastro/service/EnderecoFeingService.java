package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.enderecoFeing.EnderecoFeing;
import com.CRUD.sitema_de_cadastro.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class EnderecoFeingService {


    EnderecoFeing enderecoFeing;

    public Endereco buscarEnderecoApi(String macrorregiao)  {

        return enderecoFeing.enderecoApi(macrorregiao);

    }
}



