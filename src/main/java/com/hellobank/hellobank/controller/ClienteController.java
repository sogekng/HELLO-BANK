package com.hellobank.hellobank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IClienteService;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public ArrayList<Cliente> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        Cliente res = service.buscarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarNovo(@RequestBody Cliente novo){
        Cliente res = service.criarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(novo);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> atualizarCadastro(@RequestBody Cliente dados){
        Cliente res = service.atualizarDados(dados);
        if (res != null){
            return ResponseEntity.ok(dados);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluirCadastro(@PathVariable Integer id){
        service.excluirCadastro(id);
        return ResponseEntity.ok(null);
    }
}