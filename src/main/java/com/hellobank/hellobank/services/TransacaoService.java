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
        if (id != null){
            return dao.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Transacao criarNovo(Transacao novo) {
        Conta conta = daoConta.encontrarPorId(novo.getIdConta().getId_conta());
        if (novo != null) {
            if ("saque".equals(novo.getTipo()) && "Poupanca".equals(conta.getTipo())){
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
    public ArrayList<Transacao> extrato(Integer id) {
        if (id != null){
            return (ArrayList<Transacao>)dao.findByConsulta(id);
        }
        return null;
    }

    @Override
    public Transacao transferir(Transacao nova, Conta contaDestino){
        Transacao nova2 = new Transacao();
        if (nova != null && contaDestino != null){
            Conta contaE = daoConta.encontrarPorId(nova.getIdConta().getId_conta());
            Conta contaF = contaDestino;
            nova2.setTipo(nova.getTipo());
            nova2.setValor(nova.getValor());
            nova2.setIdConta(contaF);
            nova2.setData_transacao(nova.getData_transacao());

            if ("Poupanca".equals(contaE.getTipo())){
                if (nova.getValor() <= contaE.getSaldo()){
                    contaF.setSaldo(contaF.getSaldo() + nova.getValor());
                    contaE.setSaldo(contaE.getSaldo() - nova.getValor());
                    nova.setStatus("Negativo");
                    nova2.setStatus("Positivo");
                    dao.save(nova2);
                    return dao.save(nova);
                } else {
                    return null;
                }
            } else if ("Corrente".equals(contaE.getTipo())){
                if (nova.getValor() <= contaE.getSaldo() + 1000.00){
                    contaF.setSaldo(contaF.getSaldo() + nova.getValor());
                    contaE.setSaldo(contaE.getSaldo() - nova.getValor());
                    nova.setStatus("Negativo");
                    nova2.setStatus("Positivo");
                    dao.save(nova2);
                    return dao.save(nova);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

}