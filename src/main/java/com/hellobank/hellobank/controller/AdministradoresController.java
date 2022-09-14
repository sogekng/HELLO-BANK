package com.hellobank.hellobank.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String create(Administrador administrador, Model model1, Model model2){
        if(service.toExistCpf(administrador.getCpf())){
            model1.addAttribute("er", "Credenciais já cadastradas");
            model2.addAttribute("administradores", service.listarTodos());
            return "administradores/administradores";
        }else{
            service.toCreate(administrador);
            model1.addAttribute("ac", "Credenciais cadastradas com sucesso!");
            model2.addAttribute("administradores", service.listarTodos());
            return "administradores/administradores";
        }
    }

    @GetMapping("/administradores/{id}")
    public String search(@PathVariable Integer id, Model model){
        Optional<Administrador> admin = service.toSearch(id);
        
        try{
            model.addAttribute("administrador", admin.get());
        }catch(Exception e){
            return "redirect:/administradores";
        }

        return "administradores/edit";
    }

    @PostMapping("/administradores/{id}/update")
    public String update(@PathVariable Integer id, Administrador administrador){
        if(!service.toExistId(id)){
            return "redirect:/administradores";
        }

        service.toUpdate(administrador);

        return "redirect:/administradores";
    }
    

    @GetMapping("/administradores/delete/{id}")
    public String delete(@PathVariable Integer id){
            service.toDelete(id);
        return "redirect:/administradores";
    }
    
}
