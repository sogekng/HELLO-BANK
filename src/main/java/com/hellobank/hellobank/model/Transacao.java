package com.hellobank.hellobank.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="transacao")
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trasacao")
    private Integer id_trasacao;

    @Column(name = "id_transacao")
    private Integer id_transacao;


    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor", length = 70, nullable = false)
    private Double valor;

    @Column(name = "data_transacao", length = 20, nullable = false)
    private LocalDate dataTransacao;


    public Integer getId_trasacao() {
        return id_trasacao;
    }

    public void setId_trasacao(Integer id_trasacao) {
        this.id_trasacao = id_trasacao;
    }

    @ManyToOne
    @JoinColumn(name="id_conta")
    @JsonIgnoreProperties("listaTransacoes")
    private Conta idConta;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    public Integer getId_transacao() {
        return id_transacao;
    }

    public void setId_transacao(Integer id_transacao) {
        this.id_transacao = id_transacao;
    }

    public Conta getIdConta() {
        return idConta;
    }

    public void setIdConta(Conta idConta) {
        this.idConta = idConta;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate data_transacao) {
        this.dataTransacao = data_transacao;
    }

}
