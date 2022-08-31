package com.uce.edu.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajeroParalelo;

	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		// TODO Auto-generated constructor stub
		this.cajeroParalelo = cajeroParalelo;
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempoIni = System.currentTimeMillis();
		System.out.println("nombre hilo: " + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			atenderCliente(cliente);
		}
		System.out.println("Termino cajero: " + cajero.getNombre());
		long tiempoFin = System.currentTimeMillis();
		long tiempoDemora = (tiempoFin - tiempoIni) / 1000;
		System.out.println("Procesado "+cajero.getNombre()+" : " + tiempoDemora + " segundos");

	}

	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// debe ejecutar el metodo que se va a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajeroParalelo);
	}

}
