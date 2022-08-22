package com.uce.edu.repo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.DetalleFactura;


@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<DetalleFactura> buscarPorNumeroFechaFacturaFetch(LocalDateTime fecha, String numero) {
		// TODO Auto-generated method stub
		TypedQuery<DetalleFactura> myQ = this.em.createQuery("Select d from DetalleFactura d JOIN FETCH d.factura f WHERE f.fecha >=: fecha AND f.numero =: numero ", DetalleFactura.class);
		      myQ.setParameter("fecha", fecha);
		      myQ.setParameter("numero", numero);
		return myQ.getResultList();
	}

}
