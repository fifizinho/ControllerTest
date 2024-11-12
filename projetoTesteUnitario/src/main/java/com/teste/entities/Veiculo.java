package com.teste.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculo")
public class Veiculo {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column (name = "marca", nullable = false,  length = 255)
	private String marca;

	@NotBlank
	@Column (name = "modelo", nullable = false,  length = 255)
	private String modelo;
	
	@NotBlank
	@Column (name = "ano", nullable = false,  length = 255)
	private int ano;

	@NotBlank
	@Column (name = "cor", nullable = false,  length = 255)
	private String cor;
}
