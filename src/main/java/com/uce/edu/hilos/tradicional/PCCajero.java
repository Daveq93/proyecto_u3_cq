package com.uce.edu.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {

	
	public void procesar(Cajero cajero) {
	  System.out.println("Procesando cajero: "+cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			atenderCliente(cliente);
		}
	}
	
	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: "+cliente);
	    try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
