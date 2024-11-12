package com.CRUD.sitema_de_cadastro.repository;

import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository  extends JpaRepository<Veiculo,Long> {

   Optional<Veiculo> findByplaca(String placa);
   Optional<Veiculo> deleteByid(Long id);

}
