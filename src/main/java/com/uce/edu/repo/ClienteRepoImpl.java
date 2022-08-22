package com.uce.edu.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.em.persist(cliente);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myQ = this.em.createQuery("Select c from Cliente c WHERE c.cedula=:cedula", Cliente.class);
		return myQ.setParameter("cedula", cedula).getSingleResult();
	}

}
