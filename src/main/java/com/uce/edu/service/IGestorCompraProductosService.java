package com.uce.edu.service;

import java.util.List;

public interface IGestorCompraProductosService {

	void generarFactura(String numeroFactura, String cedulaCliente, List<String> codigosBarra);


}
