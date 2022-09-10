package com.hellobank.hellobank.dao;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Administrador;

public interface AdministradorDAO extends CrudRepository<Administrador, Integer> {
    
}