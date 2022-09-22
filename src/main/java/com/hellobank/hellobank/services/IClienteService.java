package com.hellobank.hellobank.services;

import java.util.ArrayList;
import com.hellobank.hellobank.model.Cliente;
import java.util.Optional;

public interface IClienteService  {
    public ArrayList<Cliente> listarTodos();
    public Optional<Cliente> toSearch(Integer id);
    public Optional<Cliente> toSearchCpf(String cpf);
    public boolean toExistId(Integer id);
    public boolean toExistCpf(String cpf);
    public Cliente toExistLogin(String cpf, String senha);
    public Cliente toCreate(Cliente cliente);
    public Cliente toUpdate(Cliente novoCliente);
    public void excluirCadastro(Integer id);
}