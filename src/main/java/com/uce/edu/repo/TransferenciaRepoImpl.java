package com.uce.edu.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.Transferencia;

@Transactional
@Repository
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
       this.em.persist(transferencia);
       //throw new RuntimeException();// Un RunTimeException puedo usarlo para reversar una transaccion 
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
       this.em.merge(transferencia);
	}

}
