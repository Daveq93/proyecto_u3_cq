package com.uce.edu.hilos.tradicional;

import java.util.Arrays;
import java.util.List;

public class MainHIlos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
long tiempoIni = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero();
		cajero1.setNombre("Cajera Maria");
		List<String> lista = Arrays.asList("cliente 1, cliente 2, cliente 3");
		cajero1.setClientes(lista);
		
		
		Cajero cajero2 = new Cajero();
		cajero2.setNombre("Cajero Pedro");
		List<String> lista2 = Arrays.asList("cliente 4, cliente 5, cliente 6");
		cajero2.setClientes(lista2);
		
		Cajero cajero3 = new Cajero();
		cajero3.setNombre("Cajera Karen");
		List<String> lista3 = Arrays.asList("cliente 7, cliente 8, cliente 9");
		cajero3.setClientes(lista3);
		
		PCCajero pc1 = new PCCajero();
		pc1.procesar(cajero1);
		pc1.procesar(cajero2);
		pc1.procesar(cajero3);
		
		long tiempoFin = System.currentTimeMillis();
		
		
		long tiempoDemora = (tiempoFin-tiempoIni)/1000;
		
		System.out.println("Tiempo de demora en atencion "+tiempoDemora+ " segundos");
		
	}

}
