package com.uce.edu.repo.modelo;

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
@Table(name="habitacion")
public class Habitacion {

	@Id
	@Column(name = "habi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habi_id_seq")
	@SequenceGenerator(name = "habi_id_seq", sequenceName = "habi_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="habi_numero")
	private String numero;
	@Column(name="habi_piso")
	private String piso;
	@Column(name="habi_tipo")
	private String tipo;
	
	
	@ManyToOne
	@JoinColumn(name="habi_id_hotel")
	private Hotel hotel;


	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero + ", piso=" + piso + ", tipo=" + tipo + "]";
	}
	
	
	
}
