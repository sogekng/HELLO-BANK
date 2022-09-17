package com.hellobank.hellobank.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hellobank.hellobank.dao.ContaDAO;
import com.hellobank.hellobank.dao.TransacaoDAO;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.model.Transacao;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    private TransacaoDAO dao;

    @Autowired
    private ContaDAO daoConta;

    @Override
    public ArrayList<Transacao> listarTodos() {
        return (ArrayList<Transacao>)dao.findAll();
    }

    @Override
    public Transacao buscarPorId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Transacao criarNovo(Transacao novo) {
        Conta conta = daoConta.encontrarPorId(novo.getIdConta().getId());
        if (novo != null) {
            if ("saque".equals(novo.getTipo()) && "Poupança".equals(conta.getTipo())){
                if (novo.getValor() > conta.getSaldo()){
                    return null;
                } else {
                    conta.setSaldo(conta.getSaldo() - novo.getValor());
                    return dao.save(novo);
                }
            } else if ("saque".equals(novo.getTipo()) && "Corrente".equals(conta.getTipo())) {
                if (novo.getValor() > conta.getSaldo() + 1000.00) {
                    return null;
                } else {
                    conta.setSaldo(conta.getSaldo() - novo.getValor());
                    return dao.save(novo);
                }
            } else if ("deposito".equals(novo.getTipo())) {
                conta.setSaldo(conta.getSaldo() + novo.getValor());
                return dao.save(novo);
            }
            
        }
        return null;
    }
        
    @Override
    public ArrayList<Transacao> buscarPorTipo(String palavraChave) {
        if (palavraChave != null){
            return dao.findByTipoContaining(palavraChave);
        }
        return null;
    }

    @Override
    public ArrayList<String> extrato(Integer id) {
        if (id != null){
            return (ArrayList<String>)dao.findByConsulta(id);
        }
        return null;
    }

    @Override
    public Transacao transferir(Transacao nova, Integer id) {
        if (nova != null && id != null){
            Conta contaE = daoConta.encontrarPorId(nova.getIdConta().getId());
            Conta contaF = daoConta.encontrarPorId(id);
            if ("Poupança".equals(contaE.getTipo())){
                if (nova.getValor() <= contaE.getSaldo()){
                    contaF.setSaldo(contaF.getSaldo() + nova.getValor());
                    contaE.setSaldo(contaE.getSaldo() - nova.getValor());
                    return dao.save(nova);
                } else {
                    return null;
                }
            } else if ("Corrente".equals(contaE.getTipo())){
                if (nova.getValor() <= contaE.getSaldo() + 1000.00){
                    contaF.setSaldo(contaF.getSaldo() + nova.getValor());
                    contaE.setSaldo(contaE.getSaldo() - nova.getValor());
                    return dao.save(nova);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    

   
}
