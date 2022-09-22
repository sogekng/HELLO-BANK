package com.hellobank.hellobank.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.hellobank.hellobank.services.IClienteService;
import com.hellobank.hellobank.services.ITransacaoService;
import com.hellobank.hellobank.services.IContaService;
import org.springframework.stereotype.Controller;
import com.hellobank.hellobank.model.Transacao;
import com.hellobank.hellobank.model.Cliente;
import com.hellobank.hellobank.model.Conta;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import com.hellobank.hellobank.services.CookieService;


@Controller
public class ClientesController {
    
    @Autowired
    IContaService serviceConta;
    @Autowired
    IClienteService serviceCliente;
    @Autowired
    ITransacaoService serviceTransacao;

    @GetMapping("/clientes/home")
    public String conta_create(Model model1, Model model2, Model model3, HttpServletRequest request) throws UnsupportedEncodingException{
        String idCliente = CookieService.getCookie(request, "id_cliente");
        Optional<Cliente> cliente = serviceCliente.toSearch(Integer.parseInt(idCliente));
        Optional<Conta> conta = serviceConta.toSearchIdCliente(Integer.parseInt(idCliente));
        
        if(conta.isPresent()){
            model1.addAttribute("consstt", conta.get());
            model2.addAttribute("transf", serviceTransacao.extrato(conta.get().getId_conta()));
       }

        model3.addAttribute("cliennt", cliente.get());
        return null;
    }

    @GetMapping("/clientes/conta/{id}")
    public String searchCliente(@PathVariable Integer id, Model model1, Model model2, Model model3){
        Optional<Conta> conta = serviceConta.toSearchIdCliente(id);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);

        try{
            if(conta != null){
                model1.addAttribute("cont", conta.get());
                model2.addAttribute("cliennn", cliente.get());
                return "contas/conta";
            }
        }catch(Exception e){
            model1.addAttribute("erro", "Conta não existe");
            model2.addAttribute("cliennt", cliente.get());
        }
        return "clientes/home";
    }

    @PostMapping("/clientes/conta/{id}/create")
    public String create(@PathVariable Integer id, String tipo, Conta conta, Model model1, Model model2, Model model3){
        Optional<Conta> cont = serviceConta.toSearchIdCliente(id);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);

        try{
            if(cont.isPresent()){
                model1.addAttribute("erro", "Conta já existe");
                model2.addAttribute("cliennt", cliente.get());
                return "clientes/conta/" + id;
            }else{
                serviceConta.toCreate(conta);
                model2.addAttribute("cliennt", cliente.get());
                return "clientes/conta/" + id;
            }
        }catch(Exception e){
            model1.addAttribute("cont", conta);
            model2.addAttribute("cliennt", cliente.get());
            model3.addAttribute("erro", "Erro ao criar");
            return "clientes/home";
        }
    }

    @PostMapping("/clientes/conta/{id}/transferir")
    public String transferir(@PathVariable Integer id, String cpf, Transacao nova, String valor, Model model1, Model model2, Model model3){
        Optional<Cliente> cliente = serviceCliente.toSearch(id);
        Optional<Cliente> clienteDestino = serviceCliente.toSearchCpf(cpf);
        Optional<Conta> conta = serviceConta.toSearchIdCliente(id);

        if(nova.getValor() < 0 || nova.getValor() == 0){
            model1.addAttribute("cont", conta.get());
            model2.addAttribute("cliennn", cliente.get());
            model3.addAttribute("errooo", "Valor inválido");
            return "contas/conta";
        }
        if(nova.getValor() > 10000){
            model1.addAttribute("cont", conta.get());
            model2.addAttribute("cliennn", cliente.get());
            model3.addAttribute("errooo", "Voce não pode transferir mais de R$10.000,00");
            return "contas/conta";
        }
        if (nova != null){
            
            if(nova.getTipo().equals("transferencia")){
                if(nova.getValor() > conta.get().getSaldo()){
                    model1.addAttribute("cont", conta.get());
                    model2.addAttribute("cliennn", cliente.get());
                    model3.addAttribute("errooo", "Saldo insuficiente");
                    return "contas/conta";
                }
                if(cpf != null){
                    if(clienteDestino.isPresent()){
                        Optional<Cliente> contaCliente = serviceCliente.toSearchCpf(cpf);

                        if(contaCliente != null){
                            Optional<Conta> contaDestino = serviceConta.toSearchIdCliente(contaCliente.get().getId_cliente());
                            try{
                                if(contaDestino.get() != null){
                                    serviceTransacao.transferir(nova, contaDestino.get());
                                    model1.addAttribute("accertt", "Transferência realizada com sucesso!");
                                    model2.addAttribute("cont", conta.get());
                                    model3.addAttribute("cliennn", cliente.get());
                                    return "contas/conta";
                                }else{
                                    model1.addAttribute("cont", conta.get());
                                    model2.addAttribute("cliennn", cliente.get());
                                    model3.addAttribute("errooo", "Conta não existe");
                                    return "contas/conta";
                                }
                            }catch(Exception e){
                                model1.addAttribute("cont", conta.get());
                                model2.addAttribute("cliennn", cliente.get());
                                model3.addAttribute("errooo", "Erro ao transferir");
                                return "contas/conta";
                            }
                        }         
                    }else{
                        model1.addAttribute("errooo", "Cliente não existe");
                        model2.addAttribute("cont", conta.get());
                        model3.addAttribute("cliennn", cliente.get());
                        return "contas/conta";
                    }
                }
            }else{
                if(nova.getTipo().equals("saque")){
                    if(nova.getValor() > conta.get().getSaldo()){
                        model1.addAttribute("cont", conta.get());
                        model2.addAttribute("cliennn", cliente.get());
                        model3.addAttribute("errooo", "Saldo insuficiente");
                        return "contas/conta";
                    }
                    nova.setStatus("Negativo");
                    serviceTransacao.criarNovo(nova);
                    model1.addAttribute("accertt", "Saque realizada com sucesso!");
                }else if("deposito".equals("deposito")){
                    nova.setStatus("Positivo");
                    serviceTransacao.criarNovo(nova);
                    model1.addAttribute("accertt", "Depósito realizado com sucesso!");
                }
            }
            model2.addAttribute("cont", conta.get());
            model3.addAttribute("cliennn", cliente.get());
            
        }
        return "contas/conta";
    }

    @GetMapping("/clientes/conta/{id}/extrato")
    public String extrato(@PathVariable Integer id, Model model1, Model model2, Model model3){
        if (id != null) {
            Integer cont = serviceConta.toSearchIdClienteForAccount(id);
            Optional<Conta> conta = serviceConta.toSearch(id);
            Optional<Cliente> cliente = serviceCliente.toSearch(cont);
            model1.addAttribute("transferencias", serviceTransacao.extrato(id));
            model2.addAttribute("cont", conta.get());
            model3.addAttribute("cliennn", cliente.get());
            return "transferencias/transferencia";
        }
        return "transferencias/transferencia";
    }
    
    @GetMapping("/clientes/{id}")
    public String search(@PathVariable Integer id, Model model) {
        Optional<Cliente> client = serviceCliente.toSearch(id);
        
        try{
            model.addAttribute("client", client.get());
        }catch(Exception e){
            return "redirect:/clientes";
        }

        return "clientes/cliente";
    }

    @PostMapping("/clientes/create")
    public String create(Cliente cliente){
        serviceCliente.toCreate(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/conta/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        Optional<Cliente> cliente = serviceCliente.toSearch(id);
        model.addAttribute("clientee", cliente.get());
        return "clientes/edit";
    }

    @PostMapping("/clientes/conta/{id}/update")
    public String update(@PathVariable Integer id, Model model, Cliente cliente){
        
        if(!serviceCliente.toExistId(id)){
            return "redirect:/clientes/conta/" + id;
        }

        cliente.setId_cliente(id);
        serviceCliente.toUpdate(cliente);
        return "redirect:/clientes/conta/" + id;
    }
    
}