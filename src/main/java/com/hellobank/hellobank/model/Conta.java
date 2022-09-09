package com.hellobank.hellobank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;

@Entity
@Table(name = "conta")
public class Conta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="numero", length =20, nullable = false)
    private String numero;

    @Column(name="agencia", length=7, nullable = false)
    private String agencia;

    @Column(name="tipo", length=20, nullable = false)
    private String tipo;
    
    @Column(name="saldo", nullable = false)
    private Double saldo;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    @JsonIgnoreProperties("listaContas")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
        if(this.agencia==null || this.agencia.isEmpty()){
            this.agencia =this.numero.substring(0,4);
        }
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;

        
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    
}
