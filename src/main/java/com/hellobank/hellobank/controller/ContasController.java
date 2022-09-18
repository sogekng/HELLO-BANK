package com.hellobank.hellobank.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.IContaService;
import org.springframework.stereotype.Controller;


@Controller
public class ContasController {

    @Autowired
    IContaService serviceConta;

    @GetMapping("/contas")
    public String contas(Model model1, Model model2){
        model1.addAttribute("contass", serviceConta.listarTodos());
        return "contas/contas";
    }

    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return serviceConta.buscarPorTipo(palavraChave);
    }
    
}