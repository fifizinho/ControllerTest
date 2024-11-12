package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
