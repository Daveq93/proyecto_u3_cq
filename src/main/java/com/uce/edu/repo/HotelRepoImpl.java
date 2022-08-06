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
		//para usar el LAZY, se debe especificar en el repo, cuando requerimos algo
		List<Hotel> hoteles = myQ.getResultList();
		for (Hotel h : hoteles) {
			//System.out.println(h.getHabitaciones().size());
			h.getHabitaciones().size();//para probar se utiliza un metodo de sus hijos, en este caso usamos .size()
		}
		
		return hoteles;
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
		// TODO Auto-generated method stub                                                   //h.id -> hace referencia al id del hotel    
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h,Habitacion ha WHERE h = ha.hotel AND ha.tipo = : tipo", Hotel.class);
		myQ.setParameter("tipo", tipo);
		return myQ.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.em.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQ.setParameter("tipo", tipo);
		return myQ.getResultList();
	}

	

	
	
	
	
}
