package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IClienteRepo;
import com.uce.edu.repo.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	public void insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public Cliente buscarClientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscar(cedula);
	}

}
