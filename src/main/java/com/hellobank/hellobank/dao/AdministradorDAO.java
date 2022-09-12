package com.hellobank.hellobank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Administrador;

public interface AdministradorDAO extends CrudRepository<Administrador, Integer> {
    @Query(value="select * from hellobank.administradores where cpf = :cpf and senha = :senha", nativeQuery = true)
    public Administrador loginAdmin(String cpf, String senha);
}