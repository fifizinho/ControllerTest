package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

}
