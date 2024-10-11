package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.service.VeiculoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Data
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
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

    @PutMapping("/atualizar-veiculo/{id}")
    public ResponseEntity<Veiculo> editarCliente (@RequestBody Veiculo veiculo, @PathVariable Long id) throws  Exception{
        try {
            return  new ResponseEntity<Veiculo>(veiculoService.editarVeiculo(veiculo,id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pesquisar-placa/{placa}")
    public Object pesquisarVeiculoPorPlaca(String placa) throws Exception {
        Optional <Veiculo> verificarVeiculo =  veiculoService.pesquisarVeiculoPorPlaca(placa);
        if (verificarVeiculo.isPresent()){
              return verificarVeiculo;
        }else {
             throw new Exception("Placa não cadastrada");
        }

    }
   /* @DeleteMapping
    public void deletarVeiculo (@PathVariable String placa){
        veiculoService.deletarVeiculo(placa);
    }*/

}
