package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.ModificationItem;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IFacturaElectronicaRepo;
import com.uce.edu.repo.modelo.Cliente;
import com.uce.edu.repo.modelo.DetalleFactura;
import com.uce.edu.repo.modelo.Factura;
import com.uce.edu.repo.modelo.FacturaElectronica;
import com.uce.edu.repo.modelo.Producto;


@Service
public class GestorCompraProductosServiceImpl implements IGestorCompraProductosService {
	private static Logger LOG = Logger.getLogger(GestorCompraProductosServiceImpl.class);
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IFacturaElectronicaRepo facturaElectronicaRepo;

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IProductoService productoService;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void generarFactura(String numeroFactura, String cedulaCliente, List<String> codigosBarra) {

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
		this.facturaService.insertarFactura(factura);
		
		
		//B
		LOG.debug("Actualizando stock");
		this.actualizacionStock(numeroFactura);
		
		//C
  		LOG.debug("Generando factura electtronica");
  		this.generarFacturaElectronica(numeroFactura);
		
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizacionStock(String numeroFactura) {
		// TODO Auto-generated method stub
              Factura factura = this.facturaService.buscarPorNumero(numeroFactura);
             
              for (DetalleFactura item : factura.getDetallesFactura()) {
				item.getProducto().setStock(item.getProducto().getStock() - item.getCantidad());
			}
              
              this.facturaService.actualizarFactura(factura);
              
            
	}

	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void generarFacturaElectronica(String numeroFactura) {
		// TODO Auto-generated method stub
               Factura  factura = this.facturaService.buscarPorNumero(numeroFactura);
               
               FacturaElectronica faEl = new FacturaElectronica();
               faEl.setFechaCreacion(factura.getFecha());
               faEl.setMontoFactura(factura.getMontoTotal());
               faEl.setNumeroFactura(factura.getNumero());
               faEl.setNumeroItems(factura.getDetallesFactura().size());
             
               this.facturaElectronicaRepo.insertar(faEl);
              
               
	}

}
