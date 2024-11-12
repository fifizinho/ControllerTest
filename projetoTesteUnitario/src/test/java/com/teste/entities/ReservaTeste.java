package com.teste.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservaTeste {
	
	private Reserva reserva;
	private Hospede hospede;
	private Quarto quarto;
	
	@BeforeEach
	public void setUp() {
		//Arrange
		reserva = new Reserva(1L, hospede, quarto, LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 10));
	}
	@Test
	public void testId() {
		// Act
		reserva.setId(2L);
		//Assert
		assertEquals(2L, reserva.getId(), "o Id deve ser igual ao valor atribuido");
	}
	@Test
	public void testHospede() {
		// Act
		reserva.setHospede(hospede);
		//Assert
		assertEquals(hospede, reserva.getHospede(), "o Hospede deve ser igual ao valor atribuido");
	}
	@Test
	public void testQuarto() {
		// Act
		reserva.setQuarto(quarto);
		//Assert
		assertEquals(quarto, reserva.getQuarto(), "o Quarto deve ser igual ao valor atribuido");
	}
	@Test
	public void testCheckInData() {
		// Act
		reserva.setCheckInData(LocalDate.of(2024, 9, 1));
		//Assert
		assertEquals(LocalDate.of(2024, 9, 1), reserva.getCheckInData(), "o CheckInData deve ser igual ao valor atribuido");
	}
	@Test
	public void testCheckOutData() {
		// Act
		reserva.setCheckOutData(LocalDate.of(2024, 9, 10));
		//Assert
		assertEquals(LocalDate.of(2024, 9, 10), reserva.getCheckOutData(), "o CheckOutData deve ser igual ao valor atribuido");
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Reserva novoReserva = new Reserva (3L,hospede, quarto,LocalDate.of(2024, 1, 9), LocalDate.of(2024, 10, 9));
		assertAll("novoReserva",
				()-> assertEquals(3L, novoReserva.getId()),
				()-> assertEquals(hospede, novoReserva.getHospede()),
				()-> assertEquals(quarto, novoReserva.getQuarto()),
				()-> assertEquals(LocalDate.of(2024, 1, 9), novoReserva.getCheckInData()),
				()-> assertEquals(LocalDate.of(2024, 10, 9), novoReserva.getCheckOutData()));
	}
}