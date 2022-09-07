package com.hellobank.hellobank.services;

import java.util.ArrayList;

import com.hellobank.hellobank.model.Conta;

public interface IConta {
    public Conta CriarConta(Conta dados);
    public ArrayList<Conta> recuperarTodos();
    public Conta recuperarPorId(Integer id);
}
