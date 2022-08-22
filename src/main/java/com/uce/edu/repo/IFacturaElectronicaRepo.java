package com.uce.edu.repo;

import com.uce.edu.repo.modelo.FacturaElectronica;

public interface IFacturaElectronicaRepo {

	
	void insertar(FacturaElectronica facturaElectronica);
	
	FacturaElectronica buscar(String numero);
}
