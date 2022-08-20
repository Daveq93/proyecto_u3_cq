package com.uce.edu.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	
	void realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto);

  void realizarTransferenciaFachada(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto);
}
