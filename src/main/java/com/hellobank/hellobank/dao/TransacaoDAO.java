package com.hellobank.hellobank.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.hellobank.hellobank.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
    public ArrayList<Transacao> findByTipoContaining(String palavraChave);
}
