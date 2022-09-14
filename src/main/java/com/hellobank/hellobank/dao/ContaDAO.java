package com.hellobank.hellobank.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Conta;

public interface ContaDAO extends CrudRepository<Conta, Integer> {
    public ArrayList<Conta> findByTipoContaining(String palavraChave);
    
    @Query("SELECT p FROM Conta p WHERE p.id_conta = ?1")
	public Conta encontrarPorId(Integer id);

    @Query(value="select * from hellobank.conta where tipo = :tipo and id_cliente = :id_cliente", nativeQuery = true)
    public Conta registerDaoConta(String tipo, Integer id_cliente);

}