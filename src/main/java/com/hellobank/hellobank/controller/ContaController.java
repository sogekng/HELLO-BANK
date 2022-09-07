package com.hellobank.hellobank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.IConta;

@RestController
public class ContaController {

    @Autowired
    IConta service;


    @PostMapping("/contas")
    //http://localhost:8080/contas
    public  ResponseEntity<Conta> cadastrarCliente(@RequestBody Conta dados) {
		Conta resultado = service.CriarConta(dados);
		
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		return ResponseEntity.badRequest().build();
	}


    @GetMapping("/contas")
    public List<Conta> listar(){
        return service.recuperarTodos();
    }
    
}
