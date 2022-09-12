package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.services.IContaService;

@Controller
public class HomeControllerContas {

    @Autowired
    private IContaService service;

    @GetMapping("/contas")
    public String contas(Model model){
        model.addAttribute("conta", service.listarTodos());

        return "contas/contas";
    }
}