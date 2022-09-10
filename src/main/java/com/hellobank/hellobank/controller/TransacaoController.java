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

    @PostMapping("/transacao")
    public ResponseEntity<Transacao> criarNovo(@RequestBody Transacao novo){
        Transacao res = service.criarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(novo);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/transacao/busca")
    public ResponseEntity<ArrayList<Transacao>> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        var res = service.buscarPorTipo(palavraChave);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/extrato/{id}")
    public ArrayList<String> extrato(@PathVariable Integer id){
        ArrayList<String> res = service.extrato(id);
        if (id != null) {
            return res;            
        }
        return null;
    }

    @PostMapping("/transferencia/{id}")
    public ResponseEntity<Transacao> transferencia(@RequestBody Transacao nova, @PathVariable Integer id){
        Transacao res = service.transferir(nova, id);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

}