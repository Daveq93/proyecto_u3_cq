package com.uce.edu.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.Habitacion;


@Repository
@Transactional
public class HabitacionRepoImpl implements IHabitacionRepo{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.em.persist(habitacion);
	}
	
}
