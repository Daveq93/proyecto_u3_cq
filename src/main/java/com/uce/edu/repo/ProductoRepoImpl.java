package com.uce.edu.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.em.merge(producto);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQ = this.em.createQuery("SELECT p FROM Producto p WHERE p.codigoBarra=: codigoBarra",
				Producto.class);

		return myQ.setParameter("codigoBarra", codigoBarras).getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.em.merge(producto);
	}

}
