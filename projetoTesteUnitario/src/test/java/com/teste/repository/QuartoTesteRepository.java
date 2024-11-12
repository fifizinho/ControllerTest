package com.teste.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.entities.Quarto;

@DataJpaTest
class QuartoTesteRepository {

	@Autowired
	private QuartoRepository QuartoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		Quarto Quarto1 = new Quarto(null, "123133","solteiro");
		
		Quarto saveQuarto = QuartoRepository.save(Quarto1);
		
		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId()>0);
	}
	@DisplayName("Testando Get para todos os Quartos")
	@Test
	void testGetAllRepository() {
		Quarto Quarto1 = new Quarto (null,"123121","solteiro");
		Quarto Quarto2 = new Quarto (null,"123123","solteiro");
		
		QuartoRepository.save(Quarto1);
		QuartoRepository.save(Quarto2);
		
		List<Quarto> QuartoList = QuartoRepository.findAll();
		
		assertNotNull(QuartoList);
		assertEquals(2,QuartoList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		Quarto Quarto1 = new Quarto (null,"12313","solteiro");
		
		QuartoRepository.save(Quarto1);
		
		Quarto saveQuarto = QuartoRepository.findById(Quarto1.getId()).get();
		
		assertNotNull(saveQuarto);
		assertEquals(Quarto1.getId(),saveQuarto.getId());
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateQuarto() {
		Quarto Quarto1 = new Quarto (null,"231323","solteiro");
		
		QuartoRepository.save(Quarto1);
		
		Quarto saveQuarto = QuartoRepository.findById(Quarto1.getId()).get();
		Quarto1.setNum("12312");
		Quarto1.setTipo("solteiro");
		
		Quarto updateQuarto = QuartoRepository.save(saveQuarto);
		
		assertNotNull(updateQuarto);
		assertEquals("12312", updateQuarto.getNum());
		assertEquals("solteiro", updateQuarto.getTipo());
	}
	@DisplayName("Testando Delete")
	@Test
	void testDeleteQuarto() {
		Quarto Quarto1 = new Quarto (null,"12312","solteiro");
		
		QuartoRepository.save(Quarto1);
		
		QuartoRepository.deleteById(Quarto1.getId());
		
		Optional<Quarto> QuartoOptional = QuartoRepository.findById(Quarto1.getId());
		
		assertTrue(QuartoOptional.isEmpty());
	}
}
