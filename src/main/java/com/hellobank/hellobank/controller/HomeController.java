package com.hellobank.hellobank.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hellobank.hellobank.services.CookieService;
import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.IContaService;

@Controller
public class HomeController {

<<<<<<< HEAD
=======
    @Autowired
    private IAdministradorService adminService;

>>>>>>> fa53b5dd9e5c58ba27f3005a0e9923052c938ba0
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) throws UnsupportedEncodingException { 
        model.addAttribute("nome", CookieService.getCookies(request, "nome"));
        return "home/home";
    }
}