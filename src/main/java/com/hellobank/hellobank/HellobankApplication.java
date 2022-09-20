package com.hellobank.hellobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.hellobank.hellobank"})
public class HellobankApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellobankApplication.class, args);
	}

}
