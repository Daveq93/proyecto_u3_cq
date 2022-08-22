package com.uce.edu.repo.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="detalle_factura")
public class DetalleFactura {

	@Id
	@Column(name = "defa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defa_id_seq")
	@SequenceGenerator(name = "defa_id_seq", sequenceName = "defa_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="defa_cantidad")
	private Integer cantidad;
	@Column(name="defa_sub_total")
	private BigDecimal subtotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="defa_fact_id")
	private Factura factura;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="defa_prod_id")
	private Producto producto;

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal;
	}
	
	
	
	
}
