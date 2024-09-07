package com.CRUD.sitema_de_cadastro.repository;

import com.CRUD.sitema_de_cadastro.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato,Long> {
}
