package com.hellobank.hellobank.services;

import java.util.ArrayList;
import com.hellobank.hellobank.model.Conta;
import java.util.Optional;

public interface IContaService {
    public Conta toCreate(Conta novo);
    public ArrayList<Conta> listarTodos();
    public Optional<Conta> toSearch(Integer id);
    public ArrayList<Conta> buscarPorTipo(String palavraChave);
    public Conta registerConta(String tipo, Integer id_cliente);
}
