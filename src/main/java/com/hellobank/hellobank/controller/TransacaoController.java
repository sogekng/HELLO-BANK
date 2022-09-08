package com.hellobank.hellobank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hellobank.hellobank.model.Transacao;
import com.hellobank.hellobank.services.ITransacaoService;

@RestController
public class TransacaoController {
    @Autowired
    private ITransacaoService service;

    @GetMapping("/transacao")
    public ArrayList<Transacao> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/transacao/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Integer id) {
        Transacao res = service.buscarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

}
