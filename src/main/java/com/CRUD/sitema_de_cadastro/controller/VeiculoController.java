package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.service.VeiculoService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/veiculo")
public class VeiculoController {

    VeiculoService veiculoService;

    @PostMapping("/salvar")
    public ResponseEntity<Veiculo>salvarVeiculo(@RequestBody Veiculo veiculo) throws Exception {
        try {
          return new  ResponseEntity<Veiculo>(veiculoService.salvarVeiculo(veiculo), HttpStatus.CREATED) ;

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
