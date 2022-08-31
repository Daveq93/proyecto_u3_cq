package com.uce.edu.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class Inventario extends Thread{

	private ProductoParalelo producto;
	
	public Inventario(ProductoParalelo prod) {
		this.producto=prod;
	}
	
	
	@Override
	public void run() {
		this.insertarInventario(producto);
	}
	
	
	
	
	public void insertarInventario(ProductoParalelo producto) {
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println("Insertando producto: "+producto.toString()+ "    -->> Con hilo: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
