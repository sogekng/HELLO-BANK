package com.hellobank.hellobank.services;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hellobank.hellobank.dao.ClienteDAO;
import com.hellobank.hellobank.model.Cliente;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteDAO dao;
    String emailRept; 
    private boolean emailValido;

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
        if (novo != null) {
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

    @Override
    public boolean validarEmail(Cliente email) {
        emailValido = true;
        if (email.getEmail() != null  && email.getEmail().length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email.getEmail());
            if (!matcher.matches()) {
                emailValido = false;

            }

            emailRept =email.getEmail();
        }
        return emailValido;
    }
}
