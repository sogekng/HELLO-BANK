package com.hellobank.hellobank.controller;

import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.IContaService;
import org.springframework.stereotype.Controller;

@Controller
public class ContasController {

    @Autowired
    IContaService service;

    @GetMapping("/contas")
    public String contas(Model model){
        model.addAttribute("conta", service.listarTodos());

        return "contas/contas";
    }

    @GetMapping("/conta")
    public String conta(Model model){
        model.addAttribute("con", service.listarTodos());

        return "contas/conta";
    }


    @PostMapping("/contas/create")
    public String create(Conta conta, Model model){
        service.toCreate(conta);
        model.addAttribute("con", conta);
        return "contas/conta";
    }
        

    @GetMapping("/contas/{id}")
    public String search(@PathVariable Integer id, Model model){
        Optional<Conta> conta = service.toSearch(id);
        
        try{
            model.addAttribute("conta", conta.get());
        }catch(Exception e){
            return "redirect:/clientes";
        }

        return "contas/conta";
    }

    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return service.buscarPorTipo(palavraChave);
    }
    
}