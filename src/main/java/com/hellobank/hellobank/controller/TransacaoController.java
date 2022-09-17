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


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
public class TransacaoController {

    @Autowired
    private ITransacaoService service;

    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando a lista de transações", produces = "application/json")

    @GetMapping("/transacao")
    public ArrayList<Transacao> listarTodos() {
        return service.listarTodos();
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando transção por ID", produces = "application/json")

    @GetMapping("/transacao/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Integer id) {
        Transacao res = service.buscarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @ApiResponses({
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Criando transações", consumes="application/json", produces = "application/json")

    @PostMapping("/transacao")
    public ResponseEntity<Transacao> criarNovo(@RequestBody Transacao novo){
        Transacao res = service.criarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(novo);
        }
        return ResponseEntity.badRequest().build();
    }

    
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando transações por palavra chave", produces = "application/json")

    @GetMapping("/transacao/busca")
    public ResponseEntity<ArrayList<Transacao>> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        var res = service.buscarPorTipo(palavraChave);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiResponses({
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando extrato por ID", produces = "application/json")

    @GetMapping("/extrato/{id}")
    public ArrayList<String> extrato(@PathVariable Integer id){
        ArrayList<String> res = service.extrato(id);
        if (id != null) {
            return res;            
        }
        return null;
    }

    @ApiResponses({
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Criando transferência por ID", consumes="application/json", produces = "application/json")
    @PostMapping("/transferencia/{id}")
    public ResponseEntity<Transacao> transferencia(@RequestBody Transacao nova, @PathVariable Integer id){
        Transacao res = service.transferir(nova, id);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
