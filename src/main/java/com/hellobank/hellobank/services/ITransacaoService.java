package com.hellobank.hellobank.services;

import java.util.ArrayList;

import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.model.Transacao;

public interface ITransacaoService {
    public ArrayList<Transacao> listarTodos();
    public ArrayList<Transacao> buscarPorTipo(String palavraChave);
    public ArrayList<Transacao> extrato(Integer id);
    public Transacao buscarPorId(Integer id);
    public Transacao criarNovo(Transacao novo);
    public Transacao transferir(Transacao nova, Conta contaDestino);
}