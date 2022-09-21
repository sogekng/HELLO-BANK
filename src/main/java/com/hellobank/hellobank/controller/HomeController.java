package com.hellobank.hellobank.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.hellobank.hellobank.model.Conta;
import com.hellobank.hellobank.services.IContaService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "/home/home";
    }

    @GetMapping("/home")
    public String home(){
        return "home/home";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "home/sobre";
    }
}