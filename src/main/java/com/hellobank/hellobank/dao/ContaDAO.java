package com.hellobank.hellobank.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Conta;

public interface ContaDAO extends CrudRepository<Conta, Integer> {
    public ArrayList<Conta> findByTipoContaining(String palavraChave);
    
    @Query("SELECT p FROM Conta p WHERE p.id_conta = ?1")
	public Conta encontrarPorId(Integer id);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from conta where id_conta = :id_conta", nativeQuery = true)
    public boolean existByCount(Integer id_conta);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from conta where tipo = :tipo", nativeQuery = true)
    public boolean existByType(String tipo);

}