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
@Table(name="producto")
public class Producto {
	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
	@SequenceGenerator(name = "prod_id_seq", sequenceName = "prod_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="prod_codigo_barras")
	private String codigoBarra;
	
	@Column(name="prod_nombre")
	private String nombre;
	
	@Column(name="prod_precio")
	private BigDecimal precio;
	
	@Column(name="prod_stock")
	private Integer stock;
	
	@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
	private List<DetalleFactura> detallesFactura;
	
	
	
}
