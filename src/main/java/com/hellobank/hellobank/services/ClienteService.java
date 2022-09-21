package com.hellobank.hellobank.services;

import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hellobank.hellobank.dao.ClienteDAO;
import com.hellobank.hellobank.model.Cliente;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteDAO dao;

    @Override
    public ArrayList<Cliente> listarTodos() {
        return (ArrayList<Cliente>)dao.findAll();
    }

    @Override
    public Optional<Cliente> toSearch(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Optional<Cliente> toSearchCpf(String cpf) {
        return dao.findByCpf(cpf);
    }

    @Override
    public boolean toExistId(Integer id) {
        return dao.existsById(id);
    }

    @Override
    public boolean toExistCpf(String cpf) {
        return dao.existByCpf(cpf);
    }

    @Override
    public Cliente toExistLogin(String cpf, String senha) {
        return dao.existByLogin(cpf, senha);
    }

    @Override
    public Cliente toCreate(Cliente novo) {
        if (novo != null){
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Cliente atualizarDados(Cliente dados) {
        if (dados.getId_cliente() != null && dados != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public void excluirCadastro(Integer id) {
        dao.deleteById(id);
    }
}