package com.uce.edu.service;

import com.uce.edu.repo.modelo.Producto;

public interface IProductoService {
void insertarProducto(Producto producto);
	
	Producto buscarPorCodigoBarra(String codigoBarras);
	
	void actualizarProducto(Producto producto);
}
