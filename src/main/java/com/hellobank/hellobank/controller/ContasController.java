package com.hellobank.hellobank.controller;

import java.util.Optional;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IContaService;
import com.hellobank.hellobank.services.IClienteService;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import com.hellobank.hellobank.services.CookieService;

@Controller
public class ContasController {

    @Autowired
    IContaService service;
    @Autowired
    IClienteService serviceCliente;

    @GetMapping("/contas")
    public String contas(Model model1, Model model2){
        model1.addAttribute("contass", service.listarTodos());
        return "contas/contas";
    }

    @GetMapping("/clientes/conta")
    public String conta_create(Model model1, Model model2, HttpServletRequest request) throws UnsupportedEncodingException{
        String idCliente = CookieService.getCookie(request, "id_cliente");
        Optional<Cliente> cliente = serviceCliente.toSearch(Integer.parseInt(idCliente));
        model2.addAttribute("cliennt", cliente.get());
        return "contas/home";
    }

    @PostMapping("/clientes/conta/{id}/create")
    public String create(@PathVariable Integer id, Conta conta, Model model1, Model model2, Model model3){
        Optional<Conta> cont = service.toSearchIdCliente(id);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);

        try{
            if(cont.isPresent()){
                model1.addAttribute("cont", cont.get());
                model2.addAttribute("cliennn", cliente.get());
                return "contas/conta";
            }else{
                service.toCreate(conta);
                model1.addAttribute("accertt", "Conta criada com sucesso!");
                model2.addAttribute("cont", conta);
                model3.addAttribute("cliennn", cliente.get());
                return "contas/conta";
            }
        }catch(Exception e){
            return "contas/conta";
        }
    }
        

    @GetMapping("/clientes/conta/{id}")
    public String searchCliente(@PathVariable Integer id, Model model1, Model model2, Model model3){
        Optional<Conta> conta = service.toSearchIdCliente(id);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);

        try{
            if(conta != null){
                model1.addAttribute("cont", conta.get());
                model2.addAttribute("cliennn", cliente.get());
            }
        }catch(Exception e){
            model1.addAttribute("erro", "Conta não existe");
            model2.addAttribute("cliennn", cliente.get());
        }
        return "contas/conta";
    }

    @GetMapping("/administrador/conta/{id}")
    public String searchAdmin(@PathVariable Integer id, Model model1, Model model2){
        Optional<Conta> conta = service.toSearchIdCliente(id);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);


        try{
            if(conta != null){
                model1.addAttribute("contss", conta.get());
                model2.addAttribute("clienn", cliente.get());
                return "administradores/conta";
            }
        }catch(Exception e){
            model1.addAttribute("erroor", "Conta não exite");
        }
        return "administradores/conta";
    }

    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return service.buscarPorTipo(palavraChave);
    }
    
}