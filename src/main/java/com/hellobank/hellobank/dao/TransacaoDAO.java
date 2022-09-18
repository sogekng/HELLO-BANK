package com.hellobank.hellobank.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
    public ArrayList<Transacao> findByTipoContaining(String palavraChave);
    

    /*@Query("SELECT t FROM Transacao t WHERE t.id = :idConta")
    public ArrayList<Transacao>findByConsulta(@Param("idConta") Integer idConta);*/
    

    @Query(value = "SELECT * FROM hellobank.transacao WHERE id_conta = :id", nativeQuery = true)
    public ArrayList<Transacao> findByConsulta(Integer id);

    //@Query(value = "SELECT * FROM hellobank.conta where id_cliente = :id_cliente", nativeQuery = true)
    //public String findByCpf(String cpf);

}
