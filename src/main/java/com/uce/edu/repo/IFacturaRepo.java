package com.uce.edu.repo;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repo.modelo.Factura;

public interface IFacturaRepo {

	
	Factura consultar(Integer id);
	
	void insertar(Factura factura);
	
	void actualizar(Factura factura);
	
	Factura buscarPorNumero(String numero);
	
	List<Factura> buscarPorNumeroInnerJoin(String numero);
	
	List<Factura>buscarCantidadMayorDetalleFact(Integer cantidad);
	
	List<Factura> buscarMayoresFecha(LocalDateTime fecha,Integer cantidad);
	
	
	Factura buscarPorNumeroJinWhere(String numero);
	
	List<Factura> buscarMayoresFecha(LocalDateTime fecha);
}
