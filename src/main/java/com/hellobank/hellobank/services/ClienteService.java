package com.hellobank.hellobank.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hellobank.hellobank.dao.ClienteDAO;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.libs.Cpf;
import com.hellobank.hellobank.libs.Email;
import com.hellobank.hellobank.model.Conta;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteDAO dao;

    @Override
    public ArrayList<Cliente> listarTodos() {
        return (ArrayList<Cliente>) dao.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Cliente criarNovo(Cliente novo) {
        if(novo != null && Email.validar(novo.getEmail()) && Cpf.validar(novo.getCpf())){
            for(Conta conta: novo.getListaContas()) {
                conta.setCliente(novo);
                return dao.save(novo);
            }
        }

        return null;

    }

    @Override
    public Cliente atualizarDados(Cliente dados) {
        if (dados.getId() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public void excluirCadastro(Integer id) {
        dao.deleteById(id);
    }

}
