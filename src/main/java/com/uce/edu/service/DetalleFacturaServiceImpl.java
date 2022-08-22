package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IDetalleFacturaRepo;
import com.uce.edu.repo.modelo.DetalleFactura;



@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{

	@Autowired
	private IDetalleFacturaRepo detalleFactRepo;

	@Override
	public List<DetalleFactura> buscarPorNumeroFechaFacturaFetch(LocalDateTime fecha, String numero) {
		// TODO Auto-generated method stub
		return this.detalleFactRepo.buscarPorNumeroFechaFacturaFetch(fecha, numero);
	}
	
	
	
}
