package com.CRUD.sitema_de_cadastro.repository;

import com.CRUD.sitema_de_cadastro.entity.Envolvidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvolvidosRepository extends JpaRepository<Envolvidos, Long> {
Optional<Envolvidos> findBydocumento(String documento);
}
