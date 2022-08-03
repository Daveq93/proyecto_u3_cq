package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IHabitacionRepo;
import com.uce.edu.repo.modelo.Habitacion;


@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepo habitacionRepo;



	@Override
	public void insertarHabitacion(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepo.insertar(habitacion);
	}
	
	
	
}
