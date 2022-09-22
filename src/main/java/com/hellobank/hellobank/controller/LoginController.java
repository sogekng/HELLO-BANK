package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.model.Administrador;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.services.IClienteService;


@Controller
public class LoginController {

    @Autowired
    private IAdministradorService serviceAdmin;
    
    @Autowired
    private IClienteService serviceCliente;

    @GetMapping("/forgotPassword")
    public String forgotPassword(){
        return "login/forgot-password";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @PostMapping("/logon")
    public String logon(Model model1, Model model2, Administrador administrador, Cliente cliente, String remember){
        Cliente clien = this.serviceCliente.toExistLogin(cliente.getCpf(), cliente.getSenha());
        Administrador admin = this.serviceAdmin.toExistLogin(administrador.getCpf(), administrador.getSenha());
        
        if(admin != null){
            return "redirect:/administradores/clientes";

        }else if (clien != null) {
            return "redirect:/clientes/conta/" + clien.getId_cliente();
        }

        model1.addAttribute("error", "Usuario ou senha incorretas");
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}