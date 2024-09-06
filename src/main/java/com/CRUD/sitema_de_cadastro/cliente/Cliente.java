package com.CRUD.sitema_de_cadastro.cliente;

import com.CRUD.sitema_de_cadastro.Contato.Contato;
import com.CRUD.sitema_de_cadastro.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String documento;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Endereco> enderecos;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Contato> contatos;
}
