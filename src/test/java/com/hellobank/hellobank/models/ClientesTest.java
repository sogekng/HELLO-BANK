package com.hellobank.hellobank.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hellobank.hellobank.model.Cliente;

@SpringBootTest
class ClientesTest {

	@Test
	void validarPropCliente() {
		var cliente = new Cliente();
		cliente.setNome("Pedro");

		cliente.setEmail("pedro@teste.com");
		cliente.setSenha("1234aNt@");
		cliente.setTelefone("(00) 00000-0000");
		cliente.setCpf("000.000.00-00");
		
		assertEquals("Pedro", cliente.getNome());
		assertEquals("pedro@teste.com", cliente.getEmail());
		assertEquals("1234aNt@", cliente.getSenha());
		assertEquals("(00) 00000-0000", cliente.getTelefone());
		assertEquals("000.000.00-00", cliente.getCpf());


	}

	@Test
	void ValidarNome(){
		var cliente = new Cliente();
		cliente.setNome("Pedro");
		assertEquals("Pedro", cliente.getNome());
		
	}
	
}
