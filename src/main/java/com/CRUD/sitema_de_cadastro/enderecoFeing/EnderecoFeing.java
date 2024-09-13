package com.CRUD.sitema_de_cadastro.enderecoFeing;

import com.CRUD.sitema_de_cadastro.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "viacep.com.br/ws", name = "viacep")
public interface EnderecoFeing {
    @GetMapping("/{cep}/json")
    Endereco encerecoApi (@PathVariable("cep")String cep );
}


