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
import com.hellobank.hellobank.model.Transacao;
import com.hellobank.hellobank.services.ITransacaoService;

@Controller
public class ContasController {

    @Autowired
    IContaService serviceConta;
    @Autowired
    IClienteService serviceCliente;
    @Autowired
    ITransacaoService serviceTransacao;

    @GetMapping("/contas")
    public String contas(Model model1, Model model2){
        model1.addAttribute("contass", serviceConta.listarTodos());
        return "contas/contas";
    }

    @GetMapping("/clientes/home")
    public String conta_create(Model model1, Model model2, HttpServletRequest request) throws UnsupportedEncodingException{
        String idCliente = CookieService.getCookie(request, "id_cliente");
        Optional<Cliente> cliente = serviceCliente.toSearch(Integer.parseInt(idCliente));
        model2.addAttribute("cliennt", cliente.get());
        return "clientes/home";
    }

    @GetMapping("/clientes/conta/{id}")
    public String searchCliente(@PathVariable Integer id, Model model1, Model model2, Model model3){
        Optional<Conta> conta = serviceConta.toSearchIdCliente(id);
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

    @PostMapping("/clientes/conta/{id}/create")
    public String create(@PathVariable Integer id, String tipo, Conta conta, Model model1, Model model2, Model model3){
        Optional<Conta> cont = serviceConta.toSearchCount(id, tipo);
        Optional<Cliente> cliente = serviceCliente.toSearch(id);

        try{
            if(cont.isPresent()){
                model1.addAttribute("cont", cont.get());
                model2.addAttribute("cliennn", cliente.get());
                return "contas/conta";
            }else{
                serviceConta.toCreate(conta);
                model1.addAttribute("accertt", "Conta criada com sucesso!");
                model2.addAttribute("cont", conta);
                model3.addAttribute("cliennn", cliente.get());
                return "contas/conta";
            }
        }catch(Exception e){
            return "contas/conta";
        }
    }

    @PostMapping("/clientes/conta/{id}/transferir")
    public String transferir(@PathVariable Integer id, String cpf, Transacao nova, String valor, Model model1, Model model2, Model model3){
        Optional<Cliente> cliente = serviceCliente.toSearch(id);
        Optional<Conta> conta = serviceConta.toSearchIdCliente(id);

        Double newValue = Double.parseDouble(valor);
        nova.setValor(newValue);

        if(nova.getValor() < 0 || nova.getValor() == 0){
            model1.addAttribute("cont", conta.get());
            model2.addAttribute("cliennn", cliente.get());
            model3.addAttribute("errooo", "Valor inválido");
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
                    if(cpf.equals(cliente.get().getCpf())){
                        model1.addAttribute("cont", conta.get());
                        model2.addAttribute("cliennn", cliente.get());
                        model3.addAttribute("errooo", "Não é possível transferir para a mesma conta");
                        return "contas/conta";
                    }
                    Optional<Cliente> contaCliente = serviceCliente.toSearchCpf(cpf);

                    if(contaCliente.get() != null){
                        Optional<Conta> contaDestino = serviceConta.toSearchIdCliente(contaCliente.get().getId_cliente());
                        serviceTransacao.transferir(nova, contaDestino.get());
                        model1.addAttribute("accertt", "Transferência realizada com sucesso!");
                    }else{
                        model1.addAttribute("errooo", "Cliente não existe");
                        model2.addAttribute("cont", conta.get());
                        model3.addAttribute("cliennn", cliente.get());
                        return "contas/conta";
                    }
                }
            }else{
                Transacao transacao = serviceTransacao.criarNovo(nova);

                if("saque".equals(transacao.getTipo())){
                    model1.addAttribute("accertt", "Saque realizada com sucesso!");
                }else if("deposito".equals(transacao.getTipo())){
                    model1.addAttribute("accertt", "Depósito realizado com sucesso!");
                }
            }
            model2.addAttribute("cont", conta.get());
            model3.addAttribute("cliennn", cliente.get());
            
        }
        return "contas/conta";
    }

    @GetMapping("/administrador/conta/{id}")
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

    @GetMapping("/contas/busca")
    public ArrayList<Conta> buscarPorTipo(@RequestParam(name = "palavraChave") String palavraChave){
        return serviceConta.buscarPorTipo(palavraChave);
    }
    
}