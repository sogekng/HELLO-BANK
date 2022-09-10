package com.hellobank.hellobank.dao;


import org.springframework.data.repository.CrudRepository;

import com.hellobank.hellobank.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    
}