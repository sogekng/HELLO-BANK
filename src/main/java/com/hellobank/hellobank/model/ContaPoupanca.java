package com.hellobank.hellobank.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("poupanca")
public class ContaPoupanca extends Conta {

    private Double dinheiroGuardo;
    private Double resgate;

    public Double getDinheiroGuardo() {
        return dinheiroGuardo;
    }
    public void setDinheiroGuardo(Double dinheiroGuardo) {
        this.dinheiroGuardo = dinheiroGuardo;
    }
    public Double getResgate() {
        return resgate;
    }
    public void setResgate(Double resgate) {
        this.resgate = resgate;
    }

}
