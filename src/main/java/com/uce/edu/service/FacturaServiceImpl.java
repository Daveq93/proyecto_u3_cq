package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IFacturaRepo;
import com.uce.edu.repo.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepo faturaRepo;
	
	@Override
	public Factura consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.faturaRepo.consultar(id);
	}
	
	@Override
	public void insertarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.faturaRepo.insertar(factura);
	}

	@Override
	public void actualizarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.faturaRepo.actualizar(factura);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarPorNumero(numero);
	}

	@Override
	public List<Factura> buscarPorNumeroInnerJoin(String numero) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarPorNumeroInnerJoin(numero);
	}

	@Override
	public List<Factura> buscarCantidadMayorDetalleFact(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarCantidadMayorDetalleFact(cantidad);
	}

	@Override
	public List<Factura> buscarMayoresFecha(LocalDateTime fecha, Integer cantidad) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarMayoresFecha(fecha, cantidad);
	}

	@Override
	public Factura buscarPorNumeroJoinWhere(String numero) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarPorNumeroJinWhere(numero);
	}

	

}
