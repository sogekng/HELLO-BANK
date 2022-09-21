package com.hellobank.hellobank.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.model.Administrador;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.CookieService;
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
    public String logon(Model model, Administrador administrador, Cliente cliente, String remember){
        Cliente clien = this.serviceCliente.toExistLogin(cliente.getCpf(), cliente.getSenha());
        Administrador admin = this.serviceAdmin.toExistLogin(administrador.getCpf(), administrador.getSenha());
        
        if(admin != null){
            model.addAttribute("admin", serviceAdmin.listarTodos());
            model.addAttribute("clien", serviceCliente.listarTodos());
            return "administradores/home";

        }else if (clien != null) {
            model.addAttribute("cliennt", clien);
            return "clientes/home";
        }

        model.addAttribute("error", "Usuario ou senha incorretas");
        return "redirect:/clientes/home";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}