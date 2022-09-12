package com.hellobank.hellobank.services;

import java.util.ArrayList;

import com.hellobank.hellobank.model.Conta;

public interface IContaService {
    public Conta criarNovo(Conta dados);
    public ArrayList<Conta> listarTodos();
    public Conta recuperarPorId(Integer id);
    public ArrayList<Conta> buscarPorTipo(String palavraChave);
    
}
