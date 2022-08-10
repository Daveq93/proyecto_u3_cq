package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.ITransferenciaRepo;
import com.uce.edu.repo.modelo.CuentaBancaria;
import com.uce.edu.repo.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	@Autowired
	private ITransferenciaRepo transferenciaRepo;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria cuBaOrigen = this.cuentaBancariaService.buscarPorNumero(numeroCuentaOrigen);
		CuentaBancaria cuBaDestino = this.cuentaBancariaService.buscarPorNumero(numeroCuentaDestino);
		
		cuBaOrigen.setSaldo(cuBaOrigen.getSaldo().subtract(monto));//restamos el monto de la cuenta origen
		
		cuBaDestino.setSaldo(cuBaDestino.getSaldo().add(monto));//sumamos el monto a la cuenta destino
		
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaOrigen(cuBaOrigen);
		transferencia.setCuentaDestino(cuBaDestino);
		transferencia.setMonto(monto);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setCuentaOrigen(cuBaOrigen);
		transferencia.setCuentaDestino(cuBaDestino);
		
		this.cuentaBancariaService.actualizarCuentaBancaria(cuBaDestino);
		this.cuentaBancariaService.actualizarCuentaBancaria(cuBaOrigen);
		
		this.transferenciaRepo.insertar(transferencia);
	}

	@Override
	@Transactional(value=TxType.REQUIRED) //si los 2 metodos estan con REQUIRED formaria parte de la misma transaccion
	                                      // en cambio si se anota con REQUIRES_NEW abre una nueva transacacion 
	public void realizarTransferenciaFachada(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(numeroCuentaOrigen, numeroCuentaDestino, monto);
	}

}
