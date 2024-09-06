package com.CRUD.sitema_de_cadastro.repository;

import com.CRUD.sitema_de_cadastro.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Long, Cliente> {
}
