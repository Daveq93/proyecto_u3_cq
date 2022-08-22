package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IProductoRepo;
import com.uce.edu.repo.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public void insertarProducto(Producto producto) {
		// TODO Auto-generated method stub
this.productoRepo.insertar(producto);
	}

	@Override
	public Producto buscarPorCodigoBarra(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscar(codigoBarras);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
this.productoRepo.actualizar(producto);
	}

}
