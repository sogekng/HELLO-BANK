package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.services.IClienteService;

@Controller
public class HomeControllerClientes {

    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public String clientes(Model model){
        model.addAttribute("cliente", service.listarTodos());

        return "clientes/clientes";
    }
}