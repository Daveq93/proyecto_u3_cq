package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IFacturaElectronicaRepo;
import com.uce.edu.repo.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	IFacturaElectronicaRepo facturaElecRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertarFacturaElectronica(String numeroFactura,Integer cantidadItems, BigDecimal monto) {
        
        FacturaElectronica faEl = new FacturaElectronica();
        faEl.setFechaCreacion(LocalDateTime.now());
        faEl.setMontoFactura(monto);
        faEl.setNumeroFactura(numeroFactura);
        faEl.setNumeroItems(cantidadItems);
      
        this.facturaElecRepo.insertar(faEl);
	}

	@Override
	public FacturaElectronica buscarFacturaElectronicaPorNumero(String numero) {
		return this.facturaElecRepo.buscar(numero);
	}

}
