package com.hellobank.hellobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.hellobank.hellobank.services.IAdministradorService;


@Controller
public class AdministradoresController {

    @Autowired
    private IAdministradorService service;

    @GetMapping("/administradores")
    public String administrador(Model model){
        model.addAttribute("administradores", service.listarTodos());

        return "administradores/administradores";
    }
    
}
