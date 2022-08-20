package com.uce.edu.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.repo.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{
	private static Logger LOG = Logger.getLogger(CuentaBancariaRepoImpl.class);
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.em.persist(cuentaBancaria);
		throw new RuntimeException();
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.em.merge(cuentaBancaria);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		LOG.debug("Transaccion buscar por numero: "+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQ = this.em.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =: numero", CuentaBancaria.class);
		myQ.setParameter("numero", numero);
		return myQ.getSingleResult();
	}

}
