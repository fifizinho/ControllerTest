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

import com.teste.entities.Produto;

@DataJpaTest
class ProdutoTesteRepository {

	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		Produto Produto1 = new Produto(null, "Garrafa",12312);
		
		Produto saveProduto = ProdutoRepository.save(Produto1);
		
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId()>0);
	}
	@DisplayName("Testando Get para todos os Produtos")
	@Test
	void testGetAllRepository() {
		Produto Produto1 = new Produto (null,"Agua",1221);
		Produto Produto2 = new Produto (null,"Vinho",1212);
		
		ProdutoRepository.save(Produto1);
		ProdutoRepository.save(Produto2);
		
		List<Produto> ProdutoList = ProdutoRepository.findAll();
		
		assertNotNull(ProdutoList);
		assertEquals(2,ProdutoList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		Produto Produto1 = new Produto (null,"Agua",121);
		
		ProdutoRepository.save(Produto1);
		
		Produto saveProduto = ProdutoRepository.findById(Produto1.getId()).get();
		
		assertNotNull(saveProduto);
		assertEquals(Produto1.getId(),saveProduto.getId());
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateProduto() {
		Produto Produto1 = new Produto (null,"tapete",1212);
		
		ProdutoRepository.save(Produto1);
		
		Produto saveProduto = ProdutoRepository.findById(Produto1.getId()).get();
		Produto1.setNome("Carro");
		Produto1.setPreco(11111);
		
		Produto updateProduto = ProdutoRepository.save(saveProduto);
		
		assertNotNull(updateProduto);
		assertEquals("Carro", updateProduto.getNome());
		assertEquals(11111, updateProduto.getPreco());
	}
	@DisplayName("Testando Delete")
	@Test
	void testDeleteProduto() {
		Produto Produto1 = new Produto (null,"Carro",212);
		
		ProdutoRepository.save(Produto1);
		
		ProdutoRepository.deleteById(Produto1.getId());
		
		Optional<Produto> ProdutoOptional = ProdutoRepository.findById(Produto1.getId());
		
		assertTrue(ProdutoOptional.isEmpty());
	}
}
