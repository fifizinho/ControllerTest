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

import com.teste.entities.Veiculo;

@DataJpaTest
class VeiculoTesteRepository {

	@Autowired
	private VeiculoRepository VeiculoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		Veiculo Veiculo1 = new Veiculo(null, "Julia Maria","(00)0000-0000",1212122,"2121212");
		
		Veiculo saveVeiculo = VeiculoRepository.save(Veiculo1);
		
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId()>0);
	}
	@DisplayName("Testando Get para todos os Veiculos")
	@Test
	void testGetAllRepository() {
		Veiculo Veiculo1 = new Veiculo (null,"Julio Fernando","12121212",0000000000,"1212122");
		Veiculo Veiculo2 = new Veiculo (null,"Julia Maria","1212122",0000000000,"1212122");
		
		VeiculoRepository.save(Veiculo1);
		VeiculoRepository.save(Veiculo2);
		
		List<Veiculo> VeiculoList = VeiculoRepository.findAll();
		
		assertNotNull(VeiculoList);
		assertEquals(2,VeiculoList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		Veiculo Veiculo1 = new Veiculo (null,"Julio Fernando","1212121",000000000,"1212122");
		
		VeiculoRepository.save(Veiculo1);
		
		Veiculo saveVeiculo = VeiculoRepository.findById(Veiculo1.getId()).get();
		
		assertNotNull(saveVeiculo);
		assertEquals(Veiculo1.getId(),saveVeiculo.getId());
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateVeiculo() {
		Veiculo Veiculo1 = new Veiculo (null,"Julio Fernando","121212",000000000,"1212122");
		
		VeiculoRepository.save(Veiculo1);
		
		Veiculo saveVeiculo = VeiculoRepository.findById(Veiculo1.getId()).get();
		Veiculo1.setMarca("Leonardo");
		Veiculo1.setModelo("211212122");
		
		Veiculo updateVeiculo = VeiculoRepository.save(saveVeiculo);
		
		assertNotNull(updateVeiculo);
		assertEquals("Leonardo", updateVeiculo.getMarca());
		assertEquals("211212122", updateVeiculo.getModelo());
	}
	@DisplayName("Testando Delete")
	@Test
	void testDeleteVeiculo() {
		Veiculo Veiculo1 = new Veiculo (null,"Julio Fernando","julio@gmail.com",0000000000,"211212122");
		
		VeiculoRepository.save(Veiculo1);
		
		VeiculoRepository.deleteById(Veiculo1.getId());
		
		Optional<Veiculo> VeiculoOptional = VeiculoRepository.findById(Veiculo1.getId());
		
		assertTrue(VeiculoOptional.isEmpty());
	}
}
