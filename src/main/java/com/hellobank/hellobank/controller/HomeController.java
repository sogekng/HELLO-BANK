package com.hellobank.hellobank.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        return "home/home";
    }
    @PostMapping("/logon")
    public String logar(Model model, String cpf, String password, String remeber){
        return "home/home";
    }
}