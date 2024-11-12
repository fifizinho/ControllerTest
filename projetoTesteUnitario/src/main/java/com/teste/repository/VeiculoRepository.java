package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
