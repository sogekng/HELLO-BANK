package com.hellobank.hellobank.dao;

import org.springframework.data.repository.CrudRepository;

import com.hellobank.hellobank.model.Conta;

public interface ContaDAO extends CrudRepository<Conta, Integer> {
    
}
