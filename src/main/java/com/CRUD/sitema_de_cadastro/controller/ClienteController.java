package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Cliente;
import com.CRUD.sitema_de_cadastro.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Data
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) throws Exception{
        try {
           return new ResponseEntity<Cliente>(clienteService.salvarCliente(cliente),HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente,@PathVariable Long id)throws Exception{
        try {
            return new ResponseEntity<>(clienteService.editarCliente(cliente,id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Cliente>>buscarCliente(@PathVariable Long id)throws Exception{
        try {
            return new ResponseEntity<>(clienteService.buscarCliente(id),HttpStatus.FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
