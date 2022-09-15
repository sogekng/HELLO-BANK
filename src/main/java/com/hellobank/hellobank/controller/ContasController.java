package com.hellobank.hellobank.controller;

import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IContaService;
import com.hellobank.hellobank.services.IClienteService;
import org.springframework.stereotype.Controller;

@Controller
public class ContasController {

    @Autowired
    IContaService service;
    @Autowired
    IClienteService serviceCliente;

    @GetMapping("/contas")
    public String contas(Model model1, Model model2){
        model1.addAttribute("contass", service.listarTodos());
        return "contas/contas";
    }

    @GetMapping("/conta")
    public String conta(Model model){

        return "contas/conta";
    }

    @GetMapping("/contas/create")
    public String conta_create(){
        return "conta/create";
    }
        

    @GetMapping("/clientes/conta/{id}")
    public String search(@PathVariable Integer id, Model model1, Model model2){
        Optional<Conta> conta = service.toSearch(id);

        try{
            if(conta != null){
                model1.addAttribute("cont", conta.get());
                return "contas/conta";
            }
        }catch(Exception e){
            model1.addAttribute("erro", "Conta não encontrada");
        }
        return "contas/conta";
    }

    @GetMapping("administrador/conta/{id}")
    public String searchAdmin(@PathVariable Integer id, Model model1, Model model2){
        Optional<Conta> conta = service.toSearch(id);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);

        try{
            if(conta != null){
                model1.addAttribute("contss", conta.get());
                model2.addAttribute("clienn", cliente.get());
                return "administradores/conta";
            }
        }catch(Exception e){
            model1.addAttribute("erroor", "Conta não exite");
        }
        return "administradores/conta";
    }

    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return service.buscarPorTipo(palavraChave);
    }
    
}