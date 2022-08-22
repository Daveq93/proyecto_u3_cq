package com.uce.edu.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepoImpl implements IFacturaElectronicaRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(FacturaElectronica facturaElectronica) {
			
			this.em.persist(facturaElectronica);
			throw new RuntimeException();

	}

	@Override
	public FacturaElectronica buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaElectronica> myQ = this.em.createQuery(
				"SELECT f from FacturaElectronica f where f.numeroFactura =: numero", FacturaElectronica.class);
		return myQ.setParameter("numero", numero).getSingleResult();
	}

}
