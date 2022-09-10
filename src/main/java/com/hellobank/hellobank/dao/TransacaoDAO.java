package com.hellobank.hellobank.dao;


import java.util.ArrayList;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.hellobank.model.Transacao;



public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
    public ArrayList<Transacao> findByTipoContaining(String palavraChave);
    

    /*@Query("SELECT t FROM Transacao t WHERE t.id = :idConta")
    public ArrayList<Transacao>findByConsulta(@Param("idConta") Integer idConta);*/
    

    @Query(value = "SELECT id_transacao, tipo, valor, data_transacao FROM Transacao WHERE id_conta = ?1", nativeQuery = true)
    public ArrayList<String> findByConsulta(Integer id);




}
