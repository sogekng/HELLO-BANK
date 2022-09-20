package com.hellobank.hellobank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.hellobank.hellobank.controller"))
                    .build()
                    .useDefaultResponseMessages(false)
                    .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("API do banco fictício HelloBank, desenvolvido pelo grupo 3 - DESAFIO FINAL (IF Black Then Code)")
            .description("API para gerenciar transações do banco fictício HelloBank.")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .contact(new Contact("Github", "https://github.com/sogekng/FINAL_CHALLENGE_IBM", "grupo3@dev.com"))
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .build();
        
    }
    
}