package com.hellobank.hellobank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.IContaService;
import org.springframework.stereotype.Controller;

@Controller
public class ContasController {

    @Autowired
    IContaService service;

    @GetMapping("/contas")
    public String contas(Model model){
        model.addAttribute("conta", service.listarTodos());

        return "contas/contas";
    }


    @PostMapping("/contas/create")
    public  ResponseEntity<Conta> criarNovo(@RequestBody Conta dados) {
		Conta resultado = service.criarNovo(dados);
		
		if(resultado != null) {
			return ResponseEntity.ok(dados);
		}
		return ResponseEntity.badRequest().build();
	}

    @GetMapping("/contas/{id}")
    public ResponseEntity<Conta> recuperarPorId(@PathVariable Integer id){
        Conta res = service.recuperarPorId(id);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return service.buscarPorTipo(palavraChave);
    }
    
}