package com.uce.edu.service;

import java.util.List;

public interface IGestorCompraProductosService {

	void generarFactura(String numeroFactura, String cedulaCliente, List<String> codigosBarra);

	void actualizacionStock(String numeroFactura);

	void generarFacturaElectronica(String numeroFactura);
}
