package com.hellobank.hellobank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.hellobank.hellobank.model.Administrador;
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

    @PostMapping("/administradores/create")
    public String create(Administrador administrador){
        service.toCreate(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String search(@PathVariable Integer id, Model model){
        Administrador admin = service.toSearch(id);
        model.addAttribute("administrador", admin);

        return "redirect:/administradores#edite";
    }

    @PostMapping("/administradores/{id}/update")
    public String update(@PathVariable Integer id, Administrador administrador){
        if(!service.Toexist(id)){
            return "redirect:/administradores";
        }

        return "redirect:/administradores#edite";
    }
    

    @GetMapping("/administradores/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.toDelete(id);
        return "redirect:/administradores";
    }
    
}
