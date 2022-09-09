package com.hellobank.hellobank.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hellobank.hellobank.model.Transacao;



public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {

    public ArrayList<Transacao> findByTipoContaining(String palavraChave);
    
    @Query("SELECT t FROM Transacao t WHERE t.id = :idConta")
    public ArrayList<Transacao> findByConsulta(@Param("idConta") Integer id);
}
