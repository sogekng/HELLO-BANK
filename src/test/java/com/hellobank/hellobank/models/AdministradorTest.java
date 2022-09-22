package com.hellobank.hellobank.models;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hellobank.hellobank.model.Administrador;

@SpringBootTest
class AdministradorTest {
    @Test
    void validarPropAdministrador() {
		Administrador administrador = new Administrador();
		administrador.setNome("Pedro");
		
		administrador.setSenha("admin1234aNt@");
		
		administrador.setCpf("000.000.00-00");
		String senha = administrador.getSenha().substring(0, 4) + "****";

		assertEquals("Pedro", administrador.getNome());
		assertEquals(senha, administrador.getSenha());
		assertEquals("000.000.00-00", administrador.getCpf());


	}

		

    
}
