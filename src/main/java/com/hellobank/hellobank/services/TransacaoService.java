package com.hellobank.hellobank.services;

//import java.time.LocalDate;
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
        ArrayList<Transacao> listarTudo = (ArrayList<Transacao>) dao.findAll();
        //Conta conta = daoConta.encontrarPorId(extrato.getIgetId());
        return listarTudo;
    }

    @Override
    public Transacao buscarPorId(Integer id) {
        if (id != null){
            return dao.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Transacao criarNovo(Transacao novo) {
        if (novo != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public ArrayList<Transacao> buscarPorTipo(String palavraChave) {
        if (palavraChave != null){
            return dao.findByTipoContaining(palavraChave);
        }
        return null;
    }

    @Override
    public ArrayList<Transacao> extrato(Integer id) {
        
        
        /*ArrayList<Transacao> lista = new ArrayList<Transacao>();
        for (Transacao t: lista) {
            LocalDate data = dao.findByConsulta((id).getId_transacao());
            lista.add(new Transacao(null,  ));
        }*/
        if (id != null){
            return (ArrayList<Transacao>)dao.findByConsulta(id);
        }
        return null;
    }
       


    

}
