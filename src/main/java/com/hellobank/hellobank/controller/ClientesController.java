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
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IClienteService;
import org.springframework.stereotype.Controller;

@Controller
public class ClientesController {
    
    @Autowired
    private IClienteService service;
    

    @GetMapping("/clientes")
    public String clientes(Model model){
        model.addAttribute("cliente", service.listarTodos());

        return "clientes/clientes";
    }
    

    @GetMapping("/clientes/list")
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

    @PostMapping("/clientes/create")
    public String create(Cliente cliente){
        service.toCreate(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/clientes/update")
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