package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
