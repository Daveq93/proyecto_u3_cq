package com.uce.edu.repo.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@Column(name = "cuba_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuba_id_seq")
	@SequenceGenerator(name = "cuba_id_seq", sequenceName = "cuba_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "cuba_numero")
	private String numero;
	@Column(name = "cuba_tipo")
	private String tipo;
	@Column(name = "cuba_saldo")
	private BigDecimal saldo;
	
	@OneToMany(mappedBy = "cuentaOrigen",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Transferencia> transferenciasOrigen;
	
	@OneToMany(mappedBy = "cuentaDestino",cascade = CascadeType.ALL)
	private List<Transferencia> transferenciasDestino;

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + "]";
	}
	
	
	
}
