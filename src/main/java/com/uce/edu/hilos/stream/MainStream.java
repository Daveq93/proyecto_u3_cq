package com.uce.edu.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> listaNumerosAlumnos = new ArrayList<>();
		
		for(int i=0;i<1000;i++) {
			listaNumerosAlumnos.add(i+1);
		}
		
		long tiempoIni = System.currentTimeMillis();
		
		listaNumerosAlumnos.stream().map(id->convertirIdAlumno(id)).collect(Collectors.toList()).forEach(System.out::println);
		
		long tiempoFin = System.currentTimeMillis();

		long tiempoDemora = (tiempoFin - tiempoIni) / 1000;

		System.out.println("Tiempo de demora en atencion " + tiempoDemora + " segundos");
		
	}

	
	private static String convertirIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Id: "+id.toString()+" "+"nombre hilo: "+Thread.currentThread().getName();
	}
	
}
