package com.uce.edu.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="factura_electronica")
public class FacturaElectronica {

	@Id
	@Column(name = "fael_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_id_seq")
	@SequenceGenerator(name = "fael_id_seq", sequenceName = "fael_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "fael_numero_factura")
	private String numeroFactura;
	
	@Column(name = "fael_fecha_factura")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fael_monto_actura")
	private BigDecimal montoFactura;
	
	@Column(name = "fael_numero_items")
	private Integer numeroItems;
}
