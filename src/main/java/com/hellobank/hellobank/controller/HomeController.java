package com.hellobank.hellobank.controller;

import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellobank.hellobank.services.CookieService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.model.Administrador;
import com.hellobank.hellobank.model.Cliente;

@Controller
public class HomeController {

    @Autowired
    IClienteService serviceCliente;
    @Autowired
    IAdministradorService serviceAdministrador;

    @GetMapping("/")
    public String home(){
        return "login/login";
    }
        
    @GetMapping("/homeAdmin")
    public String homeAdmin(Model model1, Model model2, Model model3, Administrador administrador){
         
        model1.addAttribute("clien", serviceCliente.listarTodos());
        model2.addAttribute("admin", serviceAdministrador.listarTodos());
        model3.addAttribute("nomeAdmin", administrador.getNome());
        return "home/homeAdmin";
    }
}