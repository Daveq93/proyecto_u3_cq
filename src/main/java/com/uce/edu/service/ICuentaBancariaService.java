package com.uce.edu.service;

import com.uce.edu.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	
void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	
	void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria);
	
	CuentaBancaria buscarPorNumero(String numero);
}
