package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.model.Administrador;
import com.hellobank.hellobank.dao.AdministradorDAO;

@Controller
public class LoginController {

    @Autowired
    private AdministradorDAO adminDAO;

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @PostMapping("/logon")
    public String logon(Model model, Administrador administrador, String remember){
        Administrador admin = this.adminDAO.loginAdmin(administrador.getCpf(), administrador.getSenha());

        if(admin != null){
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuario ou senha incorretas");
        return "login/login";
    }
}
