package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repo.modelo.Factura;

public interface IFacturaService {

	Factura consultarPorId(Integer id);

	BigDecimal gestionarFactura(String numeroFactura, String cedulaCliente, List<String> codigosBarra);
	
	void actualizarStock(String numeroFactura);

	void actualizarFactura(Factura factura);

	Factura buscarPorNumero(String numero);

	List<Factura> buscarPorNumeroInnerJoin(String numero);

	List<Factura> buscarCantidadMayorDetalleFact(Integer cantidad);

	List<Factura> buscarMayoresFecha(LocalDateTime fecha, Integer cantidad);

	Factura buscarPorNumeroJoinWhere(String numero);
}
