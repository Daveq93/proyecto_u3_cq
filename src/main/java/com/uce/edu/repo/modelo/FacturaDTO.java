package com.uce.edu.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Data;

@Data
public class FacturaDTO {

	
	private LocalDateTime fecha;
	
	private String numero;
	
	private BigDecimal montoTotal;
	
	private String nombre;
	
	private String apellido;
	
	private String cedula;
	
	
}
