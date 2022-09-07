package com.hellobank.hellobank.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.hellobank.hellobank.model.Conta;

public interface ContaDAO extends CrudRepository<Conta, Integer> {
    public ArrayList<Conta> findByTipoContaining(String palavraChave);
}
