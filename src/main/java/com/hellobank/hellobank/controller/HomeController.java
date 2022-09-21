package com.hellobank.hellobank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home/home");
	}

    @RequestMapping("/home")
	public ModelAndView homePage() {
		return new ModelAndView("home/home");
	}

    @RequestMapping("/sobre")
	public ModelAndView sobre() {
		return new ModelAndView("home/home");
	}
}