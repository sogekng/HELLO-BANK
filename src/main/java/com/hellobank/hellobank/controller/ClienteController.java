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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService service;
    

    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando a lista de clientes", produces = "application/json")

    @GetMapping("/clientes")
    public ArrayList<Cliente> listarTodos() {
        return service.listarTodos();
    }


    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Buscando cliente por ID", produces = "application/json")

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        Cliente res = service.buscarPorId(id);
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
    @ApiOperation(value = "Criando novo cliente", produces = "application/json", consumes = "application/json")

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> criarNovo(@RequestBody Cliente novo){
        Cliente res = service.criarNovo(novo);
        
        

        if (res != null ){
            return ResponseEntity.ok(novo);
        }
        
        return ResponseEntity.badRequest().build();
    }

    
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Atualizando dados de um cliente", produces = "application/json", consumes = "application/json")

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> atualizarCadastro(@RequestBody Cliente dados){
        Cliente res = service.atualizarDados(dados);
        if (res != null){
            return ResponseEntity.ok(dados);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    @ApiOperation(value = "Deletando cliente", consumes = "application/json")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluirCadastro(@PathVariable Integer id){
        service.excluirCadastro(id);
        return ResponseEntity.ok(null);
    }
}
