package com.uce.edu.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.ICuentaBancariaRepo;
import com.uce.edu.repo.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public boolean insertarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			this.cuentaBancariaRepo.insertar(cuentaBancaria);
			flag = true;
		}catch(Exception e) {
			
		}
       return flag;
	}

	@Override
	public void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
       this.cuentaBancariaRepo.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepo.buscarPorNumero(numero);
	}

}
