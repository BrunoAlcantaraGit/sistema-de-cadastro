package com.CRUD.sitema_de_cadastro.controller;

import com.CRUD.sitema_de_cadastro.entity.Envolvidos;
import com.CRUD.sitema_de_cadastro.service.EnvolvidoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/envolvido")
public class EnvolvidoController {
    EnvolvidoService envolvidoService;

    @PostMapping("/salvar")
  public ResponseEntity<Envolvidos> salvarEnvolvido (@RequestBody Envolvidos envolvidos)throws Exception{
        try {
            return new ResponseEntity<>(envolvidoService.salvarEnvolvido(envolvidos), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
  }
  @PutMapping("editar/{id}")
  public ResponseEntity<Envolvidos>editarEnvolvido(@PathVariable Long id,@RequestBody Envolvidos envolvidos) throws Exception{
      try {
         return new ResponseEntity<>(envolvidoService.editarEnvolvido(envolvidos,id),HttpStatus.OK);
      }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
  }

  @GetMapping("listar/{id}")
    ResponseEntity<Optional<Envolvidos>>listarPorId(@PathVariable Long id)throws Exception{
        try {
        return new ResponseEntity<>(envolvidoService.listarPorId(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  }

  @GetMapping("/listar-todos")
    ResponseEntity<List<Envolvidos>>ListarTudo() throws Exception{
        try {
         return  new ResponseEntity<>(envolvidoService.ListarTudo(),HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
  }
@DeleteMapping("deletar/{id}")

   public ResponseEntity deletarPorId (@PathVariable Long id)throws Exception{
        try {
            envolvidoService.deletarPorId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}

}
