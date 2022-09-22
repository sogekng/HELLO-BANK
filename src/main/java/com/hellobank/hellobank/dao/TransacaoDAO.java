package com.hellobank.hellobank.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
    public ArrayList<Transacao> findByTipoContaining(String palavraChave);
    
    @Query(value = "SELECT * FROM hellobank.transacao WHERE id_conta = :id", nativeQuery = true)
    public ArrayList<Transacao> findByConsulta(Integer id);
}
