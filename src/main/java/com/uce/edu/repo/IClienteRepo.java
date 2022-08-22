package com.uce.edu.repo;

import com.uce.edu.repo.modelo.Cliente;

public interface IClienteRepo {

	void insertar(Cliente cliente);

	Cliente buscar(String cedula);
}
