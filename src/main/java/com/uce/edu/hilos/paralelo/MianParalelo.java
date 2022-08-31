package com.uce.edu.hilos.paralelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MianParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		long tiempoIni = System.currentTimeMillis();
//
//		System.out.println("nombre hilo: "+Thread.currentThread().getName());
//		
//		CajeroParalelo cajero1 = new CajeroParalelo("Cajera 1 Maria",Arrays.asList("cliente 1, cliente 2, cliente 3"));
//		
//
//		CajeroParalelo cajero2 = new CajeroParalelo();
//		cajero2.setNombre("Cajero 2 Pedro");
//		List<String> lista2 = Arrays.asList("cliente 4, cliente 5, cliente 6");
//		cajero2.setClientes(lista2);
//
//		CajeroParalelo cajero3 = new CajeroParalelo();
//		cajero3.setNombre("Cajera 3 Karen");
//		List<String> lista3 = Arrays.asList("cliente 7, cliente 8, cliente 9");
//		cajero3.setClientes(lista3);
//
//		PCCajeroParalelo pc1 = new PCCajeroParalelo(cajero1);
//		pc1.start();
//		PCCajeroParalelo pc2 = new PCCajeroParalelo(cajero2);
//		pc2.start();
//		PCCajeroParalelo pc3 = new PCCajeroParalelo(cajero3);
//		pc3.start();
//
//		long tiempoFin = System.currentTimeMillis();
//
//		long tiempoDemora = (tiempoFin - tiempoIni) / 1000;
//
//		System.out.println("Tiempo de demora en atencion " + tiempoDemora + " segundos");
		
		
		System.out.println("---------------- Tarea 35 -------------------------");
		long tiempoIni = System.currentTimeMillis();
		
		
		ProductoParalelo p1= new ProductoParalelo("Coca-cola","1265410215");
		ProductoParalelo p2= new ProductoParalelo("Avena","1005410212");
		ProductoParalelo p3= new ProductoParalelo("Pilsener","1021047985");
		ProductoParalelo p4= new ProductoParalelo("Club","1025040140");
		ProductoParalelo p5= new ProductoParalelo("Cocoa","1020007981");
		
		List<ProductoParalelo> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);
		
		
		for(int i=0;i<lista.size();i++) {
		   Inventario inve = new Inventario(lista.get(i));
		   inve.start();
		}
			
		long tiempoFin = System.currentTimeMillis();

		long tiempoDemora = (tiempoFin - tiempoIni) / 1000;

		System.out.println("Tiempo de demora en insercion de prod " + tiempoDemora + " segundos");
	}

}
