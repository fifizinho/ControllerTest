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

import com.teste.entities.Cliente;

@DataJpaTest
class ClienteTesteRepository {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		Cliente Cliente1 = new Cliente(null, "Julia Maria","(00)0000-0000","1212122","2121212");
		
		Cliente saveCliente = ClienteRepository.save(Cliente1);
		
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId()>0);
	}
	@DisplayName("Testando Get para todos os Clientes")
	@Test
	void testGetAllRepository() {
		Cliente Cliente1 = new Cliente (null,"Julio Fernando","12121212","(00)0000-0000","1212122");
		Cliente Cliente2 = new Cliente (null,"Julia Maria","1212122","(00)0000-0000","1212122");
		
		ClienteRepository.save(Cliente1);
		ClienteRepository.save(Cliente2);
		
		List<Cliente> ClienteList = ClienteRepository.findAll();
		
		assertNotNull(ClienteList);
		assertEquals(2,ClienteList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		Cliente Cliente1 = new Cliente (null,"Julio Fernando","1212121","(00)0000-0000","1212122");
		
		ClienteRepository.save(Cliente1);
		
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		
		assertNotNull(saveCliente);
		assertEquals(Cliente1.getId(),saveCliente.getId());
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateCliente() {
		Cliente Cliente1 = new Cliente (null,"Julio Fernando","121212","(00)0000-0000","1212122");
		
		ClienteRepository.save(Cliente1);
		
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		Cliente1.setNome("Leonardo");
		Cliente1.setCpf("211212122");
		
		Cliente updateCliente = ClienteRepository.save(saveCliente);
		
		assertNotNull(updateCliente);
		assertEquals("Leonardo", updateCliente.getNome());
		assertEquals("211212122", updateCliente.getCpf());
	}
	@DisplayName("Testando Delete")
	@Test
	void testDeleteCliente() {
		Cliente Cliente1 = new Cliente (null,"Julio Fernando","julio@gmail.com","(00)0000-0000","211212122");
		
		ClienteRepository.save(Cliente1);
		
		ClienteRepository.deleteById(Cliente1.getId());
		
		Optional<Cliente> ClienteOptional = ClienteRepository.findById(Cliente1.getId());
		
		assertTrue(ClienteOptional.isEmpty());
	}
}
