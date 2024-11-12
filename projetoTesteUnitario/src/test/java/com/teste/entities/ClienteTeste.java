package com.teste.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTeste {

	private Cliente Cliente;
	
	@BeforeEach
	void setUp() {
		//Arrange
		Cliente = new Cliente(1L,"Cainan","1212112","30287601","11231233");
	}
	@Test
	@DisplayName("Testando o getter and setter do Id")
	void testId() {
		//Act
		Cliente.setId(2L);
		//Assert
		assertEquals(2L, Cliente.getId());
	}
	@Test
	@DisplayName("Testando o getter and setter do Nome")
	void testNome() {
		//Act
		Cliente.setNome("Julia");
		//Assert
		assertEquals("Julia", Cliente.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter and setter do CPF")
	void testCpf() {
		//Act
		Cliente.setCpf("1212123");
		//Assert
		assertEquals("1212123", Cliente.getCpf());
	}
	@Test
	@DisplayName("Testando o getter and setter do RG")
	void testRg() {
		//Act
		Cliente.setRg("1212123");
		//Assert
		assertEquals("1212123", Cliente.getRg());
	}
	@Test
	@DisplayName("Testando o getter and setter do Telefone")
	void testTelefone() {
		//Act
		Cliente.setTelefone("123131212");
		//Assert
		assertEquals("123131212", Cliente.getTelefone());
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Cliente novoCliente = new Cliente (3L,"Paulo","2313112","930000223","12312331");
		assertAll("novoCliente",
				()-> assertEquals(3L, novoCliente.getId()),
				()-> assertEquals("Paulo", novoCliente.getNome()),
				()-> assertEquals("2313112", novoCliente.getTelefone()),
				()-> assertEquals("930000223", novoCliente.getCpf()),
				()-> assertEquals("12312331", novoCliente.getRg()));
	}
	
}
