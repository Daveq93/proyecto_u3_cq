package com.uce.edu.hilos.paralelo;

import java.util.Arrays;
import java.util.List;


public class MianParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		long tiempoIni = System.currentTimeMillis();

		System.out.println("nombre hilo: "+Thread.currentThread().getName());
		
		CajeroParalelo cajero1 = new CajeroParalelo("Cajera 1 Maria",Arrays.asList("cliente 1, cliente 2, cliente 3"));
		

		CajeroParalelo cajero2 = new CajeroParalelo();
		cajero2.setNombre("Cajero 2 Pedro");
		List<String> lista2 = Arrays.asList("cliente 4, cliente 5, cliente 6");
		cajero2.setClientes(lista2);

		CajeroParalelo cajero3 = new CajeroParalelo();
		cajero3.setNombre("Cajera 3 Karen");
		List<String> lista3 = Arrays.asList("cliente 7, cliente 8, cliente 9");
		cajero3.setClientes(lista3);

		PCCajeroParalelo pc1 = new PCCajeroParalelo(cajero1);
		pc1.start();
		PCCajeroParalelo pc2 = new PCCajeroParalelo(cajero2);
		pc2.start();
		PCCajeroParalelo pc3 = new PCCajeroParalelo(cajero3);
		pc3.start();

		long tiempoFin = System.currentTimeMillis();

		long tiempoDemora = (tiempoFin - tiempoIni) / 1000;

		System.out.println("Tiempo de demora en atencion " + tiempoDemora + " segundos");
		
	}

}
