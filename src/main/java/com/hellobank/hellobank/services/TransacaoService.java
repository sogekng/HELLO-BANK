package com.hellobank.hellobank.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.hellobank.dao.TransacaoDAO;
import com.hellobank.hellobank.model.Transacao;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    private TransacaoDAO dao;

    @Override
    public ArrayList<Transacao> listarTodos() {
        // TODO Auto-generated method stub
        return (ArrayList<Transacao>) dao.findAll();
    }

    @Override
    public Transacao buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        return dao.findById(id).orElse(null);
    }

    @Override
    public Transacao criarNovo(Transacao novo) {
        if (novo != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Transacao efetuarSaque(String tipo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Transacao efetuarDeposito(Double valor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Transacao efetuarTransferencia(Double valor) {
        // TODO Auto-generated method stub
        return null;
    }

}
