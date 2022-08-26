package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.ModificationItem;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IFacturaElectronicaRepo;
import com.uce.edu.repo.modelo.Cliente;
import com.uce.edu.repo.modelo.DetalleFactura;
import com.uce.edu.repo.modelo.Factura;
import com.uce.edu.repo.modelo.FacturaElectronica;
import com.uce.edu.repo.modelo.Producto;


@Service
public class GestorCompraProductosServiceImpl implements IGestorCompraProductosService {
	private static Logger LOG = Logger.getLogger(GestorCompraProductosServiceImpl.class);
	
	@Autowired
	private IFacturaElectronicaService factuElectService;;

	@Autowired
	private IFacturaService facturaService;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void generarFactura(String numeroFactura, String cedulaCliente, List<String> codigosBarra) {

		BigDecimal totalPagar = this.facturaService.gestionarFactura(numeroFactura, cedulaCliente, codigosBarra);
		
		factuElectService.insertarFacturaElectronica(numeroFactura, codigosBarra.size(), totalPagar);
		
		
		
	}

}
