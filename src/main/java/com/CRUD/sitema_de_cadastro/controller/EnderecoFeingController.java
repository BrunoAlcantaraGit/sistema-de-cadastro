package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Endereco;
import com.CRUD.sitema_de_cadastro.entity.EnderecoRequest;
import com.CRUD.sitema_de_cadastro.service.EnderecoFeingService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Data
@RequestMapping("/endereco")
public class EnderecoFeingController {
    EnderecoFeingService enderecoFeingService;

    @GetMapping("/buscar-endereco/{cep}")
      public ResponseEntity<Endereco> buscarPeloCep(@PathVariable EnderecoRequest cep)  {
        return new ResponseEntity<>((enderecoFeingService.enderecoApi(cep)), HttpStatus.OK);
    }
}
