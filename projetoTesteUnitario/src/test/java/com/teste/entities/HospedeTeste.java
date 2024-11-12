package com.teste.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTeste {

	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		//Arrange
		hospede = new Hospede(1L,"Cainan","cainan.fidelis@gmail.com","30287601");
	}
	@Test
	@DisplayName("Testando o getter and setter do Id")
	void testId() {
		//Act
		hospede.setId(2L);
		//Assert
		assertEquals(2L, hospede.getId());
	}
	@Test
	@DisplayName("Testando o getter and setter do Nome")
	void testNome() {
		//Act
		hospede.setNome("Julia");
		//Assert
		assertEquals("Julia", hospede.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter and setter do Email")
	void testEmail() {
		//Act
		hospede.setEmail("julia@gmail.com");
		//Assert
		assertEquals("julia@gmail.com", hospede.getEmail());
	}
	@Test
	@DisplayName("Testando o getter and setter do Telefone")
	void testTelefone() {
		//Act
		hospede.setTelefone("123131212");
		//Assert
		assertEquals("123131212", hospede.getTelefone());
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Hospede novoHospede = new Hospede (3L,"Paulo","paulo@gmail.com","930000223");
		assertAll("novoHospede",
				()-> assertEquals(3L, novoHospede.getId()),
				()-> assertEquals("Paulo", novoHospede.getNome()),
				()-> assertEquals("paulo@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("930000223", novoHospede.getTelefone()));
	}
	
}
