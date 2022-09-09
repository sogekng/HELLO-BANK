package com.hellobank.hellobank.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Administrador;

public interface Administradores extends CrudRepository<Administrador, Integer> {
       
}
