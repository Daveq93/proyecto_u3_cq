package com.uce.edu.repo;

import com.uce.edu.repo.modelo.Producto;

public interface IProductoRepo {

	
	void insertar(Producto producto);
	
	Producto buscar(String codigoBarras);
	
	void actualizar(Producto producto);
}
