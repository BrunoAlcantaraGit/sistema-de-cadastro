package com.CRUD.sitema_de_cadastro.repository;

import com.CRUD.sitema_de_cadastro.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoFeingRepository extends JpaRepository<Endereco,Long> {
}
