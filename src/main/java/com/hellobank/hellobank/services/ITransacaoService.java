package com.hellobank.hellobank.services;

import java.util.ArrayList;

import com.hellobank.hellobank.model.Transacao;

public interface ITransacaoService {

    public ArrayList<Transacao> listarTodos();

    public Transacao buscarPorId(Integer id);
    
    public Transacao criarNovo( Transacao novo);
    
}
