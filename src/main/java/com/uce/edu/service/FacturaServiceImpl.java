package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IFacturaRepo;
import com.uce.edu.repo.modelo.Cliente;
import com.uce.edu.repo.modelo.DetalleFactura;
import com.uce.edu.repo.modelo.Factura;
import com.uce.edu.repo.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService{
	private static Logger LOG = Logger.getLogger(FacturaServiceImpl.class);
	@Autowired
	private IFacturaRepo faturaRepo;
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IProductoService productoService;
	
	@Override
	public Factura consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.faturaRepo.consultar(id);
	}
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public BigDecimal gestionarFactura(String numeroFactura, String cedulaCliente, List<String> codigosBarra) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteService.buscarClientePorCedula(cedulaCliente);

		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		
		

		BigDecimal montoTotal = new BigDecimal(0.0);
		
		List<DetalleFactura> listaDeFa = new ArrayList<>();

		for (int i = 0; i < codigosBarra.size(); i++) {
			DetalleFactura dF = new DetalleFactura();
			dF.setCantidad(1);
			dF.setFactura(factura);
			Producto prod = this.productoService.buscarPorCodigoBarra(codigosBarra.get(i));
			
			dF.setProducto(prod);
			dF.setSubtotal(prod.getPrecio().multiply(new BigDecimal(dF.getCantidad())));
			
			listaDeFa.add(dF);
			
		}
		
		
		factura.setDetallesFactura(listaDeFa);
		for (int i = 0; i < listaDeFa.size(); i++) {
			montoTotal = montoTotal.add(listaDeFa.get(i).getSubtotal());
		}
		
		factura.setMontoTotal(montoTotal);
		
		//A
		LOG.debug("Insertando factura");
		this.faturaRepo.insertar(factura);
		this.actualizarStock(numeroFactura);
		
		return montoTotal;
	}

	
	@Override
	@Transactional(value= TxType.REQUIRED)
	public void actualizarStock(String numeroFactura) {
		// TODO Auto-generated method stub
		Factura factura = this.faturaRepo.buscarPorNumero(numeroFactura);
        
        for (DetalleFactura item : factura.getDetallesFactura()) {
			item.getProducto().setStock(item.getProducto().getStock() - item.getCantidad());
		}
        
        this.faturaRepo.actualizar(factura);
	}
	
	@Override
	public void actualizarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.faturaRepo.actualizar(factura);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarPorNumero(numero);
	}

	@Override
	public List<Factura> buscarPorNumeroInnerJoin(String numero) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarPorNumeroInnerJoin(numero);
	}

	@Override
	public List<Factura> buscarCantidadMayorDetalleFact(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarCantidadMayorDetalleFact(cantidad);
	}

	@Override
	public List<Factura> buscarMayoresFecha(LocalDateTime fecha, Integer cantidad) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarMayoresFecha(fecha, cantidad);
	}

	@Override
	public Factura buscarPorNumeroJoinWhere(String numero) {
		// TODO Auto-generated method stub
		return this.faturaRepo.buscarPorNumeroJinWhere(numero);
	}

	

	

}
