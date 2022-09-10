package com.hellobank.hellobank.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.hellobank.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where email = :email", nativeQuery = true)
    public boolean emailExiste(String email);
}
