package com.hellobank.hellobank.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("poupanca")
public class ContaCorrente {
    
	private Double saldo;

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    
    
}
