package com.hellobank.hellobank.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hellobank.hellobank.dao.ContaDAO;
import com.hellobank.hellobank.model.Conta;

@Service
public class ContaService implements IContaService{

    @Autowired
    ContaDAO dao;


    @Override
    public ArrayList<Conta> listarTodos() {
        return (ArrayList<Conta>) dao.findAll();
    }

    @Override
    public Optional<Conta> toSearch(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Optional<Conta> toSearchIdCliente(Integer id_cliente) {
        return dao.findByIdCliente(id_cliente);
    }

    @Override
    public Integer toSearchIdClienteForAccount(Integer id_conta) {
        return dao.findByIdClienteForAccount(id_conta);
    }

    @Override
    public ArrayList<Conta> toListCounts(Integer id_cliente) {
        return (ArrayList<Conta>) dao.findByIdClienteArray(id_cliente);
    }
    
    @Override
    public Conta toCreate(Conta conta) {
        if (conta != null){
            return dao.save(conta);
        }
        return null;
    }

    @Override
    public ArrayList<Conta> buscarPorTipo(String palavraChave) {
        if (palavraChave != null) {
            return dao.findByTipoContaining(palavraChave);
        }
        return null;
    }
}