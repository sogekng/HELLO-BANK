package com.hellobank.hellobank.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Cliente;
import java.util.Optional;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where cpf = :cpf", nativeQuery = true)
    public boolean existByCpf(String cpf);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where id = :id", nativeQuery = true)
    public boolean existById(int id);

    @Query(value="select * from cliente where cpf = :cpf and senha = :senha", nativeQuery = true)
    public Cliente existByLogin(String cpf, String senha);

    @Query(value = "select * from cliente where cpf = :cpf", nativeQuery = true)
    public Optional<Cliente> findByCpf(String cpf);

    @Modifying
    @Query(value = "UPDATE cliente SET cpf = :cpf, email = :email, nome = :nome, senha = :senha, telefone = :telefone WHERE id_cliente = :id_cliente", nativeQuery = true)
    public Cliente updateCliente(String cpf, String email, String nome, String senha, String telefone, int id_cliente);
}