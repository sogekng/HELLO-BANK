package com.hellobank.hellobank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IClienteService;
import org.springframework.stereotype.Controller;
import com.hellobank.hellobank.model.Transacao;
import com.hellobank.hellobank.services.ITransacaoService;

@Controller
public class ClientesController {
    
    @Autowired
    private IClienteService service;
    @Autowired
    private ITransacaoService serviceTransferencia;


    @GetMapping("/clientes")
    public String clientes(Model model){
        model.addAttribute("cliente", service.listarTodos());

        return "clientes/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String search(@PathVariable Integer id, Model model) {
        Optional<Cliente> client = service.toSearch(id);
        
        try{
            model.addAttribute("client", client.get());
        }catch(Exception e){
            return "redirect:/clientes";
        }

        return "clientes/cliente";
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