package com.hellobank.hellobank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where cpf = :cpf", nativeQuery = true)
    public boolean existByCpf(String cpf);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where id = :id", nativeQuery = true)
    public boolean existById(int id);

    @Query(value="select * from cliente where cpf = :cpf and senha = :senha", nativeQuery = true)
    public Cliente existByLogin(String cpf, String senha);
}