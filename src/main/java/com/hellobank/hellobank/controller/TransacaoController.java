package com.hellobank.hellobank.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Transacao;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IContaService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.ITransacaoService;
import java.util.Optional;


@RestController
public class TransacaoController {
    
    @Autowired
    IContaService serviceConta;
    @Autowired
    IClienteService serviceCliente;
    @Autowired
    ITransacaoService serviceTransacao;

    @GetMapping("/transacao/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Integer id) {
        Transacao res = serviceTransacao.buscarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/transacao")
    public ResponseEntity<Transacao> criarNovo(@RequestBody Transacao novo){
        Transacao res = serviceTransacao.criarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(novo);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/transacao/busca")
    public ResponseEntity<ArrayList<Transacao>> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        var res = serviceTransacao.buscarPorTipo(palavraChave);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/extrato/{id}")
    public ArrayList<String> extrato(@PathVariable Integer id){
        ArrayList<String> res = serviceTransacao.extrato(id);
        if (id != null) {
            return res;            
        }
        return null;
    }

}