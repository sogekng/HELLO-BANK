package com.hellobank.hellobank.model;

import javax.persistence.*;

@Entity
@Table(name = "administradores")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "nome", length = 70, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 20, nullable = false)
    private String cpf;

    @Column(name = "senha", length = 70, nullable = false)
    private String senha;

    @OneToMany(mappedBy="administradores", cascade = CascadeType.ALL)

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha.substring(0, 4) + "****";
    }
}
