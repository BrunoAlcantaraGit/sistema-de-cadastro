package com.CRUD.sitema_de_cadastro.repository;

import com.CRUD.sitema_de_cadastro.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findBydocumento(String documento);

}
