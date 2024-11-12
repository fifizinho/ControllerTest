package com.teste.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.entities.Hospede;
import com.teste.repository.HospedeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class HospedeServiceTest {

	@Autowired
	private HospedeService hospedeService;

	@Autowired
	private HospedeRepository hospedeRepository;

	@BeforeEach
	void setUp() {
		hospedeRepository.deleteAll();
	}

	@DisplayName("Testando salvar Hospede")
	@Test
	void testSalvarHospede() {
		Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");

		Hospede resultado = hospedeService.salvarHospede(hospede);

		assertNotNull(resultado);
		assertEquals("Julia Maria", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}

	@DisplayName("Testando listar todos os hospedes")
	@Test
	void testListarTodos() {
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		Hospede hospede2 = new Hospede(null, "Julia Mario", "julio@gmail.com", "(00)0000-0000");

		hospedeService.salvarHospede(hospede1);
		hospedeService.salvarHospede(hospede2);

		List<Hospede> resultado = hospedeService.listarTodos();

		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}

	@DisplayName("Testando Buscar Hospede por Id")
	@Test
	void testBuscarPorId() {
		Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");

		Hospede salvo = hospedeService.salvarHospede(hospede);
		Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());

		assertTrue(resultado.isPresent());
		assertEquals("Julia Maria", resultado.get().getNome());

	}

	@DisplayName("Testando atualizar Hospede")
	@Test
	void testAtualizarHospede() {
		Hospede hospede = new Hospede(null, "Julio Fernando", "julio@gmail.com", "(00)0000-0000");
		Hospede salvo = hospedeService.salvarHospede(hospede);

		salvo.setNome("Leonardo");
		salvo.setEmail("leonardo@gmail.com");
		
		Hospede atualizado = hospedeService.atualizarHospede(salvo);
		
		assertNotNull(atualizado);
		assertEquals("Leonardo", atualizado.getNome());
		assertEquals("leonardo@gmail.com", atualizado.getEmail());
	}
	@DisplayName("Testando Delete")
	@Test
	void testDeleteHospede() {
		Hospede hospede = new Hospede (null,"Julio Fernando","julio@gmail.com","(00)0000-0000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		hospedeService.deletarHospede(salvo.getId());
		
		Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	}
}
