package com.hellobank.hellobank.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.hellobank.dao.ContaDAO;
import com.hellobank.hellobank.model.Conta;

@Service
public class ContaService implements IConta{

    @Autowired
    ContaDAO dao;


    @Override
    public ArrayList<Conta> recuperarTodos() {
        return (ArrayList<Conta>) dao.findAll();
    }

    @Override
    public Conta recuperarPorId(Integer id) {
        if (id != null) {
            return dao.findById(id).orElse(null);
        }
        return null;
    }
    

    @Override
    public Conta criarNovo(Conta dados) {
        return dao.save(dados);
    }

    @Override
    public ArrayList<Conta> buscarPorTipo(String palavraChave) {
        if (palavraChave != null) {
            return dao.findByTipoContaining(palavraChave);
        }
        return null;
    }
    
}