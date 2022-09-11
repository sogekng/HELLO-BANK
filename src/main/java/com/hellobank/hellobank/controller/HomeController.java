package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.services.IClienteService;

@Controller
public class HomeController {

    @Autowired
    private IAdministradorService adminService;

    @GetMapping("/")
    public String administrador(Model model){
        model.addAttribute("administradores", adminService.listarTodos());

        return "home/home";
    }

    @PostMapping("/logon")
    public String logar(Model model, String cpf, String password, String remeber){
        return "home/home";
    }
}