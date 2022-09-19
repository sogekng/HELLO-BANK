package com.hellobank.hellobank.services;

import java.util.ArrayList;
import com.hellobank.hellobank.model.Conta;
import java.util.Optional;

public interface IContaService {
    public Conta toCreate(Conta conta);
    public ArrayList<Conta> listarTodos();
    public ArrayList<Conta> toListCounts(Integer id_cliente);
    public Optional<Conta> toSearch(Integer id);
    public Optional<Conta> toSearchIdCliente(Integer id_cliente);
    public Integer toSearchIdClienteForAccount(Integer id_conta);
    public ArrayList<Conta> buscarPorTipo(String palavraChave);
}
