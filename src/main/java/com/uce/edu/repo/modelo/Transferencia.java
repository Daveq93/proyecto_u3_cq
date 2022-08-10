package com.uce.edu.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="transferencia")
public class Transferencia {
	@Id
	@Column(name = "tran_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_id_seq")
	@SequenceGenerator(name = "tran_id_seq", sequenceName = "tran_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "tran_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "tran_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name="tran_id_cuenta_origen")
	private CuentaBancaria cuentaOrigen;
	
	@ManyToOne
	@JoinColumn(name="tran_id_cuenta_destino")
	private CuentaBancaria cuentaDestino;
	

}
