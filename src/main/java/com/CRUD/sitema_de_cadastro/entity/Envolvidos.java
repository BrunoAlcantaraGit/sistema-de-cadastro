package com.CRUD.sitema_de_cadastro.entity;

import jakarta.persistence.*;

@Entity
public class Envolvidos {

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
