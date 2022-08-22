package com.uce.edu.repo;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repo.modelo.DetalleFactura;





public interface IDetalleFacturaRepo {
	List<DetalleFactura> buscarPorNumeroFechaFacturaFetch(LocalDateTime fecha,String numero);
}
