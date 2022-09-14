package com.hellobank.hellobank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Administrador;

public interface AdministradorDAO extends CrudRepository<Administrador, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from administradores where cpf = :cpf and senha = :senha", nativeQuery = true)
    public boolean existByLogin(String cpf, String senha);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from administradores where cpf = :cpf", nativeQuery = true)
    public boolean existByCpf(String cpf);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from administradores where id = :id", nativeQuery = true)
    public boolean existById(int id);
}