package com.teste.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VeiculoTeste {

	private Veiculo Veiculo;
	
	@BeforeEach
	void setUp() {
		//Arrange
		Veiculo = new Veiculo(1L,"Ford","novo",2010,"rosa");
	}
	@Test
	@DisplayName("Testando o getter and setter do Id")
	void testId() {
		//Act
		Veiculo.setId(2L);
		//Assert
		assertEquals(2L, Veiculo.getId());
	}
	@Test
	@DisplayName("Testando o getter and setter do Marca")
	void testMarca() {
		//Act
		Veiculo.setMarca("fusca");
		//Assert
		assertEquals("fusca", Veiculo.getMarca());
	}
	
	@Test
	@DisplayName("Testando o getter and setter do Modelo")
	void testModelo() {
		//Act
		Veiculo.setModelo("novo");
		//Assert
		assertEquals("novo", Veiculo.getModelo());
	}
	@Test
	@DisplayName("Testando o getter and setter do Ano")
	void testAno() {
		//Act
		Veiculo.setAno(2013);
		//Assert
		assertEquals(2013, Veiculo.getAno());
	}
	@Test
	@DisplayName("Testando o getter and setter do Cor")
	void testCor() {
		//Act
		Veiculo.setCor("preto");
		//Assert
		assertEquals("preto", Veiculo.getCor());
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Veiculo novoVeiculo = new Veiculo (3L,"Ford","novo",2009,"branco");
		assertAll("novoVeiculo",
				()-> assertEquals(3L, novoVeiculo.getId()),
				()-> assertEquals("Ford", novoVeiculo.getMarca()),
				()-> assertEquals("novo", novoVeiculo.getModelo()),
				()-> assertEquals(2009, novoVeiculo.getAno()),
				()-> assertEquals("branco", novoVeiculo.getCor()));
	}
	
}
