package com.hellobank.hellobank.services;

import java.util.ArrayList;

import com.hellobank.hellobank.model.Cliente;

public interface IClienteService  {
    public ArrayList<Cliente> listarTodos();
    public Cliente buscarPorId(Integer id);
    public Cliente criarNovo(Cliente novo);
    public Cliente atualizarDados(  Cliente dados);
    public void excluirCadastro(Integer id);
    //public boolean validarCadastro(String email, String cpf);
    
       
    
}
