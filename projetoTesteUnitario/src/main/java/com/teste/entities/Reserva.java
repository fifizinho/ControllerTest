package com.teste.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_Hospede", nullable = false)
	private Hospede hospede;
	
	@ManyToOne
	@JoinColumn(name = "id_Quarto", nullable = false)
	private Quarto quarto;
	
	@NotBlank
	@Column (name = "checkInData", nullable = false,  length = 255)
	private LocalDate checkInData;

	@NotBlank
	@Column (name = "checkOutData", nullable = false,  length = 255)
	private LocalDate checkOutData;
}
