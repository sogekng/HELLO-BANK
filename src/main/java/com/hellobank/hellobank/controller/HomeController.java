package com.hellobank.hellobank.controller;

import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.hellobank.hellobank.services.CookieService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.IAdministradorService;

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

    @GetMapping("/homeCliente")
    public String homeCliente(){
        return "home/homeCliente";
    }
        
    @GetMapping("/homeAdmin")
    public String homeAdmin(Model model1, Model model2, Model model3, HttpServletRequest request) throws UnsupportedEncodingException{
        String res = CookieService.getCookies(request, "nome");
         
        model1.addAttribute("client", serviceCliente.listarTodos());
        model2.addAttribute("admin", serviceAdministrador.listarTodos());
        model3.addAttribute("nomer", res);
        return "home/homeAdmin";
    }
}