package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.enderecoFeing.EnderecoFeing;
import com.CRUD.sitema_de_cadastro.entity.Cliente;
import com.CRUD.sitema_de_cadastro.entity.Endereco;
import com.CRUD.sitema_de_cadastro.entity.EnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.management.RuntimeMXBean;

@Service
@Data
@AllArgsConstructor
public class EnderecoFeingService {
    EnderecoFeing enderecoFeing;
    public Endereco enderecoApi(EnderecoRequest enderecoRequest) {
        return  enderecoFeing.encerecoApi(enderecoRequest.getCep());
    }
}



