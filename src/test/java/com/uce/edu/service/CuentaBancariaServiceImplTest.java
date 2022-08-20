package com.uce.edu.service;




import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.repo.modelo.CuentaBancaria;

@SpringBootTest
class CuentaBancariaServiceImplTest {

	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	@Test
	void InsertarCuentabancaria() {
		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.setNumero("CUBA-123");
		cb1.setSaldo(new BigDecimal(200));
		cb1.setTipo("A");
		
		//assertTrue(this.cuentaBancariaService.insertarCuentaBancaria(cb1));
	}

}
