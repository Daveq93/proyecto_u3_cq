package com.uce.edu.CuentaBancariaService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.repo.modelo.CuentaBancaria;
import com.uce.edu.service.ICuentaBancariaService;
import com.uce.edu.service.ITransferenciaService;

@SpringBootTest
public class CuentaBancariaTest {

	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	@Autowired
	private ITransferenciaService transferenciaService;
	
	
	//@Test
		public void insertarCuentabancaria() {
			CuentaBancaria cb = new CuentaBancaria();
			cb.setNumero("ASD-120014");
			cb.setSaldo(new BigDecimal(600));
			cb.setTipo("A");

			//this.cuentaBancariaService.insertarCuentaBancaria(cb);
			CuentaBancaria cb2 = this.cuentaBancariaService.buscarPorNumero("ASD-120014");

			assertThat(cb2).extracting(CuentaBancaria::getTipo).isEqualTo("A");
			
			assertThat(cb2.getSaldo(),equalTo(cb.getSaldo()));
			
		}
	
	
	@BeforeEach
		public void cuentas() {
			CuentaBancaria cb1 = this.cuentaBancariaService.buscarPorNumero("A-211");
			CuentaBancaria cb2 = this.cuentaBancariaService.buscarPorNumero("A-111");
			System.out.println(cb1.toString());
			
			
			assertThat(cb1.getSaldo()).isEqualByComparingTo(new BigDecimal(680));
			assertThat(cb2.getSaldo()).isEqualByComparingTo(new BigDecimal(620));
			
			
		}

		@Test
		public void testTransferencia() {	
			assertTrue(this.transferenciaService.realizarTransferencia("A-211", "A-111", new BigDecimal(10)));
			
		}

		@AfterEach
		public void verificarSaldos() {
			CuentaBancaria cb1 = this.cuentaBancariaService.buscarPorNumero("A-211");
			CuentaBancaria cb2 = this.cuentaBancariaService.buscarPorNumero("A-111");
			
			assertThat(cb1.getSaldo()).isEqualByComparingTo(new BigDecimal(670));
			assertThat(cb2.getSaldo()).isEqualByComparingTo(new BigDecimal(630));
					
		}
}
