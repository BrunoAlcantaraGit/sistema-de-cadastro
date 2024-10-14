package com.CRUD.sitema_de_cadastro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String documento;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne( cascade = CascadeType.ALL)
    private Contato contato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Endereco getEnderecos() {
        return endereco;
    }

    public void setEnderecos(Endereco enderecos) {
        this.endereco = enderecos;
    }

    public Contato getContatos() {
        return contato;
    }

    public void setContatos(Contato contatos) {
        this.contato = contatos;
    }
}
