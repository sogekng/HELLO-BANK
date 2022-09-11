package com.hellobank.hellobank.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Administrador;

public interface AdministradorDAO extends CrudRepository<Administrador, Integer> {
    @Query(value="SELECT CASE WHEN COUNT(1) > 0 THEN 'true' ELSE 'false' END FROM administradores WHERE id = :id", nativeQuery = true)
    public boolean Toexist(Integer id);
}