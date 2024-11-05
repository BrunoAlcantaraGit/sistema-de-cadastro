package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Cliente;
import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.service.VeiculoService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@Data
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    VeiculoService veiculoService;
    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);


    @PostMapping("/salvar")
    public ResponseEntity<Veiculo>salvarVeiculo(@RequestBody Veiculo veiculo) throws Exception {
        logger.info("Dados recebidos do cliente: {}", veiculo);

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
              return new ResponseEntity<>( veiculoService.pesquisarVeiculoPorPlaca(placa),HttpStatus.OK);
        }else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
  @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPorId(@PathVariable Long id) throws Exception {
       try {
           veiculoService.deletarPorId(id);
           return new  ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
  }

  @GetMapping("/listar")
    public ResponseEntity<List<Veiculo>>listarVeiculos()throws Exception{
        try {
            return new ResponseEntity<>(veiculoService.listarVeiculos(),HttpStatus.OK);
        }catch (Exception e){

           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  }

  @GetMapping("/listar-por-id/{id}")
    public ResponseEntity<Optional<Veiculo>>busacarVeiculoID(@PathVariable Long id) throws Exception{
        try {
           return new ResponseEntity<>(veiculoService.busacarVeiculoID(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  }

}
