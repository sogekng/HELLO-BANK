package com.hellobank.hellobank.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hellobank.hellobank.model.Conta;



@SpringBootTest
class ContaTest {
	

	@Test
	void validarPropCliente() {
		var conta = new Conta();
		conta.setNumero("0000000-0");

		conta.setAgencia("0000");
		conta.setSaldo(100.00);
		conta.setTipo("Conta Corrente");
		//assertequal é uma função que faz uma validacao sobre um dado
		;
		assertEquals("0000", conta.getAgencia());
		assertEquals("0000000-0", conta.getNumero());
		assertEquals(100.00, conta.getSaldo());
		assertEquals("Conta Corrente", conta.getTipo());
		
	}
	@Test
	void aoSetarNumeroGerarAgenciaVazia() {
		var conta = new Conta();
		//quando eu seto um número eu preencho uma agencia
		conta.setNumero("0000000-0");
		assertEquals("0000", conta.getAgencia());
	}
	void aoSetarNumeroNaoGerarAgenciaNaoVazia() {
		var conta = new Conta();
		conta.setAgencia("2332");
		conta.setNumero("0847246-7");
		assertEquals("2332", conta.getAgencia());
	}
}