package com.uce.edu.repo;

import com.uce.edu.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {

	void insertar(CuentaBancaria cuentaBancaria);
	
	void actualizar(CuentaBancaria cuentaBancaria);
	
	
	CuentaBancaria buscarPorNumero(String numero);
}
