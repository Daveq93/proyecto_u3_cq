package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repo.modelo.Factura;

public interface IFacturaService {

	Factura consultarPorId(Integer id);

	void insertarFactura(Factura factura);

	void actualizarFactura(Factura factura);

	Factura buscarPorNumero(String numero);

	List<Factura> buscarPorNumeroInnerJoin(String numero);

	List<Factura> buscarCantidadMayorDetalleFact(Integer cantidad);

	List<Factura> buscarMayoresFecha(LocalDateTime fecha, Integer cantidad);

	Factura buscarPorNumeroJoinWhere(String numero);
}
