package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Endereco;
import com.CRUD.sitema_de_cadastro.service.EnderecoFeingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoFeingController {
  EnderecoFeingService enderecoFeingService;



    @GetMapping("/buscar-cep/{cep}")
      public ResponseEntity<Endereco> buscarPeloCep(@PathVariable String cep){
       return new ResponseEntity<>(enderecoFeingService.buscarEnderecoApi(cep),HttpStatus.OK);

    }
}
