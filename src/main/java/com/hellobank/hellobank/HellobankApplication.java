package com.hellobank.hellobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"com.hellobank.hellobank"})
public class HellobankApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellobankApplication.class, args);
	}

}
