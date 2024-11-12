package com.teste.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTeste {

	private Quarto Quarto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		Quarto = new Quarto(1L,"19081","solteiro");
	}
	@Test
	@DisplayName("Testando o getter and setter do Id")
	void testId() {
		//Act
		Quarto.setId(2L);
		//Assert
		assertEquals(2L, Quarto.getId());
	}
	@Test
	@DisplayName("Testando o getter and setter do Numero")
	void testNum() {
		//Act
		Quarto.setNum("1231212");
		//Assert
		assertEquals("1231212", Quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o getter and setter do Tipo")
	void testTipo() {
		//Act
		Quarto.setTipo("solteiro");
		//Assert
		assertEquals("solteiro", Quarto.getTipo());
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Quarto novoQuarto = new Quarto (3L,"123134","solteiro");
		assertAll("novoQuarto",
				()-> assertEquals(3L, novoQuarto.getId()),
				()-> assertEquals("123134", novoQuarto.getNum()),
				()-> assertEquals("solteiro", novoQuarto.getTipo()));
	}
	
}
