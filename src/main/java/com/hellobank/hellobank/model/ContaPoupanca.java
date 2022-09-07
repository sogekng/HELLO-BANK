package com.hellobank.hellobank.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("poupanca")
public class ContaPoupanca extends Conta {

    private Double dinheiroGuardo;

    public Double getDinheiroGuardo() {
        return dinheiroGuardo;
    }
    public void setDinheiroGuardo(Double dinheiroGuardo) {
        this.dinheiroGuardo = dinheiroGuardo;
    }

}
