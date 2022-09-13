package com.hellobank.hellobank.services;

import java.util.ArrayList;
import com.hellobank.hellobank.model.Cliente;

public interface IClienteService  {
    public ArrayList<Cliente> listarTodos();
    public Cliente buscarPorId(Integer id);
    public Cliente toCreate(Cliente cliente);
    public Cliente atualizarDados(  Cliente dados);
    public void excluirCadastro(Integer id);
    public Cliente loginCliente(String cpf, String senha);
    public Cliente registerCliente(String cpf, String email);
}