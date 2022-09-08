package com.hellobank.hellobank.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transacao")
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trasacao")
    private Integer id_trasacao;

    @Column(name = "valor", length = 70, nullable = false)
    private Double valor;

    @Column(name = "data", length = 20, nullable = false)
    private LocalDate data;

    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;

    public Transacao() {}
	public Transacao(Integer id_trasacao, Double valor, LocalDate data, String tipo) {
        this.id_trasacao = id_trasacao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    Conta conta = new Conta();

    public Integer getId_trasacao() {
        return id_trasacao;
    }

    public void setId_trasacao(Integer id_trasacao) {
        this.id_trasacao = id_trasacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }

    
}
