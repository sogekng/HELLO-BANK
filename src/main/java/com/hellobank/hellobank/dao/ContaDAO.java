package com.hellobank.hellobank.dao;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hellobank.hellobank.model.Conta;
import java.util.Optional;

@Repository
public interface ContaDAO extends CrudRepository<Conta, Integer> {
    public ArrayList<Conta> findByTipoContaining(String palavraChave);
    
    @Query("SELECT p FROM Conta p WHERE p.id_conta = ?1")
	public Conta encontrarPorId(Integer id);

    @Query(value="select * from hellobank.conta where id_cliente = :id_cliente", nativeQuery = true)
    public Optional<Conta> findByIdCliente(Integer id_cliente);

    @Query(value="select id_cliente from hellobank.conta where id_conta = :id_conta", nativeQuery = true)
    public Integer findByIdClienteForAccount(Integer id_conta);

    @Query(value="select * from conta where id_cliente = :id_cliente", nativeQuery = true)
    public ArrayList<Conta> findByIdClienteArray(Integer id_cliente);

}