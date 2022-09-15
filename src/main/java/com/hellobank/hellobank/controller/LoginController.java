package com.hellobank.hellobank.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.model.Administrador;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.CookieService;
import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.IContaService;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private IAdministradorService serviceAdmin;
    @Autowired
    private IClienteService serviceCliente;
    @Autowired
    private IContaService serviceConta;

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @PostMapping("/logon")
    public String logon(Model model1, Model model2, Administrador administrador, Cliente cliente, String remember, HttpServletResponse response) throws IOException{
        if(serviceAdmin.toExistLogin(administrador.getCpf(), administrador.getSenha())){
            Integer time = remember != null ? 60*60 : 60*60*24;
            CookieService.setCookie(response, "nome", String.valueOf(administrador.getNome()), time);
            model1.addAttribute("admin", serviceAdmin.listarTodos());
            model2.addAttribute("clien", serviceCliente.listarTodos());
            return "home/homeAdmin";
        }
        else if(serviceCliente.toExistLogin(cliente.getCpf(), cliente.getSenha())){
            Integer time = remember != null ? 60*60 : 60*60*24;
            CookieService.setCookie(response, "nome", String.valueOf(cliente.getNome()), time);
            model1.addAttribute("cliennt", serviceCliente.listarTodos());
            return "contas/create";
        }

        model1.addAttribute("error", "Usuario ou senha incorretas");
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException{
        CookieService.setCookie(response, "id", "", 0);
        CookieService.setCookie(response, "nome", "", 0);
        return "redirect:/login";
    }
}
