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

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @PostMapping("/logon")
    public String logon(Model model, Administrador administrador, Cliente cliente, String remember, HttpServletResponse request) throws IOException{
        Administrador admin = serviceAdmin.loginAdmin(administrador.getCpf(), administrador.getSenha());

        if(admin != null){
            Integer time = remember != null ? 60*60 : 60*60*24;
            CookieService.setCookies(request, "id", String.valueOf(administrador.getId()), time);
            CookieService.setCookies(request, "nome", String.valueOf(administrador.getNome()), time);
            return "redirect:/homeAdmin";
        }

        Cliente client = serviceCliente.loginCliente(cliente.getCpf(), cliente.getSenha());

        if(client != null){
            Integer time = remember != null ? 60*60 : 60*60*24;
            CookieService.setCookies(request, "nome", String.valueOf(cliente.getNome()), time);
            return "redirect:/homeCliente";
        }

        model.addAttribute("error", "Usuario ou senha incorretas");
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse request) throws IOException{
        CookieService.setCookies(request, "id", "", 0);
        return "redirect:/login";
    }
}
