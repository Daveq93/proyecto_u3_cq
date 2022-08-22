package com.uce.edu.repo.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seq")
	@SequenceGenerator(name = "clie_id_seq", sequenceName = "clie_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "clie_nombre")
	private String nombre;
	
	@Column(name = "clie_apellido")
	private String apellido;
	
	@Column(name = "clie_cedula")
	private String cedula;
	
	@Column(name = "clie_direccion")
	private String direccion;
	
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
	private List<Factura> facturas;

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", direccion=" + direccion + "]";
	}
	
	
	
}
