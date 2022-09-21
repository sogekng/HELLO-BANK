package com.hellobank.hellobank.controller;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import com.hellobank.hellobank.services.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Administrador;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.services.IAdministradorService;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.IContaService;


@Controller
public class AdministradoresController {

    @Autowired
    private IAdministradorService serviceAdministrador;
    @Autowired
    private IClienteService serviceCliente;
    @Autowired
    private IContaService serviceConta;

    @GetMapping("/administradores/home")
    public String conta_create(Model model1, Model model2, Model model3, HttpServletRequest request) throws UnsupportedEncodingException{
        String nomeAdmin = CookieService.getCookie(request, "nome_admin");
        model1.addAttribute("clien", serviceCliente.listarTodos());
        model2.addAttribute("admin", serviceAdministrador.listarTodos());
        model3.addAttribute("nome_administrador", nomeAdmin);
        return "administradores/home";
    }

    @GetMapping("/administradores/administradores")
    public String administrador(Model model){
        model.addAttribute("administradores", serviceAdministrador.listarTodos());

        return "administradores/administradores";
    }

    @GetMapping("/administradores/clientes")
    public String clientes(Model model){
        model.addAttribute("cliente", serviceCliente.listarTodos());

        return "clientes/clientes";
    }

    @PostMapping("/administradores/administradores/create")
    public String create(Administrador administrador, Model model1, Model model2){
        if(serviceAdministrador.toExistCpf(administrador.getCpf())){
            model1.addAttribute("er", "Credenciais já cadastradas");
            model2.addAttribute("administradores", serviceAdministrador.listarTodos());
            return "administradores/administradores";
        }else{
            serviceAdministrador.toCreate(administrador);
            model1.addAttribute("ac", "Credenciais cadastradas com sucesso!");
            model2.addAttribute("administradores", serviceAdministrador.listarTodos());
            return "administradores/administradores";
        }
    }

    @GetMapping("/administradores/administradores/{id}")
    public String search(@PathVariable Integer id, Model model){
        Optional<Administrador> admin = serviceAdministrador.toSearch(id);
        
        try{
            model.addAttribute("administrador", admin.get());
        }catch(Exception e){
            return "redirect:/administradores";
        }

        return "administradores/edit";
    }

    @GetMapping("/administradores/clientes/conta/{id}")
    public String searchAdmin(@PathVariable Integer id, Model model1, Model model2){
        Optional<Conta> conta = serviceConta.toSearchIdCliente(id);
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

    @PostMapping("/administradores/administradores/{id}/update")
    public String update(@PathVariable Integer id, Administrador administrador){
        if(!serviceAdministrador.toExistId(id)){
            return "redirect:/administradores/administradores";
        }

        serviceAdministrador.toUpdate(administrador);

        return "redirect:/administradores/administradores";
    }

    @GetMapping("/administradores/administradores/{id}/delete")
    public String deleteAdministradores(@PathVariable Integer id){
        serviceAdministrador.toDelete(id);
        return "redirect:/administradores/administradores";
    }
    
    @GetMapping("/administradores/clientes/{id}/delete")
    public String deleteClientes(@PathVariable Integer id){
        serviceCliente.excluirCadastro(id);
        return "redirect:/administradores/clientes";
    }
}