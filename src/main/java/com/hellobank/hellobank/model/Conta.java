package com.hellobank.hellobank.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="conta")
public class Conta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conta")
    private Integer id_conta;

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

    @OneToMany(mappedBy="idConta", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("idConta")
    private List<Transacao> listaTransacoes;

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

    public Integer getId_conta() {
        return id_conta;
    }

    public void setId_conta(Integer id_conta) {
        this.id_conta = id_conta;
    }
}
