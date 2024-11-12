package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
