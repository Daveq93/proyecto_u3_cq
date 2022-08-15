package com.uce.edu.repo.modelo;

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
@Table(name="hotel")
public class Hotel {

	@Id
	@Column(name = "hote_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hote_id_seq")
	@SequenceGenerator(name = "hote_id_seq", sequenceName = "hote_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="hote_nombre")
	private String nombre;
	@Column(name="hote_direccion")
	private String direccion;
	
	// el fetch EAGER es mucho mas costosa, porque ejecuta un sql para cada habitacion
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Habitacion> habitaciones;

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
}
