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
    private IClienteService serviceCliente;

    @GetMapping("/register")
    public String register(){
        return "register/register";
    }

    @PostMapping("/register/create")
    public String create(Cliente cliente, Model model){
        if(serviceCliente.toExistCpf(cliente.getCpf())){
            model.addAttribute("err", "CPF já cadastrado");
            return "register/register";
        }else{
            serviceCliente.toCreate(cliente);
            model.addAttribute("ace", "Credenciais cadastradas com sucesso!");
            return "redirect:/login";
        }
    }
}
