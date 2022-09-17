package com.hellobank.hellobank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.IConta;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ContaController {

    @Autowired
    IConta service;


    @ApiResponses({
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Criando contas", produces = "application/json", consumes = "application/json")

    @PostMapping("/contas")
    //http://localhost:8080/contas
    public  ResponseEntity<Conta> criarNovo(@RequestBody Conta dados) {
		Conta resultado = service.criarNovo(dados);
		
		if(resultado != null) {
			return ResponseEntity.ok(dados);
		}
		return ResponseEntity.badRequest().build();
	}


    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando lista de contas", produces = "application/json")

    @GetMapping("/contas")
    public List<Conta> listar(){
        return service.recuperarTodos();
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando conta por ID", produces = "application/json")

    @GetMapping("/contas/{id}")
    public ResponseEntity<Conta> recuperarPorId(@PathVariable Integer id){
        Conta res = service.recuperarPorId(id);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }


    @ApiResponses({
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando contas por palavra chave", produces = "application/json")


    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return service.buscarPorTipo(palavraChave);
    }
    
}
