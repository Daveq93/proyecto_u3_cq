package com.uce.edu.service;

import com.uce.edu.repo.modelo.Cliente;

public interface IClienteService {
	void insertarCliente(Cliente cliente);

	Cliente buscarClientePorCedula(String cedula);
}
