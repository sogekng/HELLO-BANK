package com.hellobank.hellobank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    @Query(value="select * from hellobank.cliente where cpf = :cpf and senha = :senha", nativeQuery = true)
    public Cliente loginDaoCliente(String cpf, String senha);
}