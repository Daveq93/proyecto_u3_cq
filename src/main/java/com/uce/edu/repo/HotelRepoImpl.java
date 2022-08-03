package com.uce.edu.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.Hotel;


@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.em.persist(hotel);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipo) {
		// TODO Auto-generated method stub
		//puede ir JOIN   o INNER JOIN -> es igual
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQ.setParameter("tipo", tipo);
		return myQ.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha", Hotel.class);
		return myQ.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQ.setParameter("tipo", tipo);
		return myQ.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha ", Hotel.class);
		return myQ.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQ.setParameter("tipo", tipo);
		return myQ.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
}
