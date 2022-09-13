package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IClienteService;

@Controller
public class RegisterController {

    @Autowired
    private IClienteService service;

    @GetMapping("/register")
    public String register() {
        return "register/register";
    }

    @PostMapping("/register/create")
    public String create(Model model, Cliente cliente) {
        Cliente client = service.registerCliente(cliente.getCpf(), cliente.getEmail());

        if(client != null){
            model.addAttribute("erro", "Usuario ja existe");
            return "register/register";
        }else{
            service.toCreate(cliente);
            return "redirect:/login";
        }
    }
}
