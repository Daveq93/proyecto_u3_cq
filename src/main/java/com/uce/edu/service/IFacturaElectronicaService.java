package com.uce.edu.service;

import java.math.BigDecimal;

import com.uce.edu.repo.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {
	void insertarFacturaElectronica(String numeroFactura,Integer cantidadItems, BigDecimal monto);
	
	FacturaElectronica buscarFacturaElectronicaPorNumero(String numero);
}
