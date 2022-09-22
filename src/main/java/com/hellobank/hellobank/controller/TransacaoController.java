package com.hellobank.hellobank.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hellobank.hellobank.model.Transacao;
import com.hellobank.hellobank.services.IContaService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.ITransacaoService;


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

}