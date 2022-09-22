package com.hellobank.hellobank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/home";
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