package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repo.modelo.DetalleFactura;



public interface IDetalleFacturaService {
	List<DetalleFactura> buscarPorNumeroFechaFacturaFetch(LocalDateTime fecha,String numero);
}
