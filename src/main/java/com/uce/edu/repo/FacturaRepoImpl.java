package com.uce.edu.repo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.repo.modelo.DetalleFactura;
import com.uce.edu.repo.modelo.Factura;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.em.find(Factura.class, id);
	}
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.em.merge(factura);
	}

	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.em.merge(factura);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Factura buscarPorNumero(String numero) {
		TypedQuery<Factura> myQ = this.em.createQuery("Select f FROM Factura f JOIN FETCH f.detallesFactura WHERE f.numero=:numero", Factura.class);
		Factura f =myQ.setParameter("numero", numero).getSingleResult();
		f.getDetallesFactura().size();
		
		return f;
	}
	

	@Override
	public List<Factura> buscarPorNumeroInnerJoin(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.em.createQuery("Select f FROM Factura f JOIN f.detallesFactura df WHERE f.numero =: numero", Factura.class);
		myQ.setParameter("numero", numero);
		List<Factura> listaF = myQ.getResultList();
		for (Factura item : listaF) {
			item.getDetallesFactura().size();
		}
		
		return listaF;
	}

	@Override
	public List<Factura> buscarCantidadMayorDetalleFact(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.em.createQuery("SELECT f FROM Factura f LEFT JOIN f.detallesFactura df WHERE df.cantidad > : cantidad",Factura.class);
		myQ.setParameter("cantidad", cantidad);
		return myQ.getResultList();
	}

	@Override
	public List<Factura> buscarMayoresFecha(LocalDateTime fecha,Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.em.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detallesFactura df WHERE f.fecha >:fecha and df.cantidad >= : cantidad",Factura.class);
		myQ.setParameter("fecha", fecha);
		myQ.setParameter("cantidad",cantidad );
		return myQ.getResultList();
	}

	@Override
	public Factura buscarPorNumeroJinWhere(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.em.createQuery("SELECT f  FROM Factura f, DetalleFactura df WHERE f = df.factura and f.numero = : numero ", Factura.class);
		myQ.setParameter("numero", numero);
		return myQ.getSingleResult() ;
	}



	



	
}
