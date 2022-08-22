package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repo.modelo.Cliente;
import com.uce.edu.repo.modelo.CuentaBancaria;
import com.uce.edu.repo.modelo.Habitacion;
import com.uce.edu.repo.modelo.Hotel;
import com.uce.edu.repo.modelo.Producto;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.ICuentaBancariaService;
import com.uce.edu.service.IGestorCompraProductosService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.IProductoService;
import com.uce.edu.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3CqApplication implements CommandLineRunner{
	private static Logger LOG = Logger.getLogger(ProyectoU3CqApplication.class);
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private IGestorCompraProductosService gestorCompraService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IProductoService productoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3CqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Hotel h1 = new Hotel();
		h1.setDireccion("Loja");
		h1.setNombre("Hotel 1");
		
		List<Habitacion> listaHabi1 = new ArrayList<>();
		
		Habitacion ha1 = new Habitacion();
		ha1.setNumero("A1");
		ha1.setPiso("1");
		ha1.setTipo("Normal");
		ha1.setHotel(h1);
		
		Habitacion ha2 = new Habitacion();
		ha2.setNumero("A2");
		ha2.setPiso("1");
		ha2.setTipo("Familiar");
		ha2.setHotel(h1);
		
		Habitacion ha3 = new Habitacion();
		ha3.setNumero("A3");
		ha3.setPiso("1");
		ha3.setTipo("Matrimonial");
		ha3.setHotel(h1);
		
		listaHabi1.add(ha1);
		listaHabi1.add(ha2);
		listaHabi1.add(ha3);
		
		h1.setHabitaciones(listaHabi1);
		
		//this.hotelService.insertarHotel(h1);
		
		
		
		Hotel h2 = new Hotel();
		h2.setDireccion("Cuenca");
		h2.setNombre("Hotel 2");
		
		List<Habitacion> listaHabi2 = new ArrayList<>();
		
		Habitacion ha4 = new Habitacion();
		ha4.setNumero("B1");
		ha4.setPiso("2");
		ha4.setTipo("Normal");
		ha4.setHotel(h2);
		
		Habitacion ha5 = new Habitacion();
		ha5.setNumero("B2");
		ha5.setPiso("2");
		ha5.setTipo("Normal");
		ha5.setHotel(h2);
		
		Habitacion ha6 = new Habitacion();
		ha6.setNumero("B3");
		ha6.setPiso("2");
		ha6.setTipo("Matrimonial");
		ha6.setHotel(h2);
		
		listaHabi2.add(ha4);
		listaHabi2.add(ha5);
		listaHabi2.add(ha6);
		
		h2.setHabitaciones(listaHabi2);
		//this.hotelService.insertarHotel(h2);
		
		
		Hotel h3 = new Hotel();
		h3.setDireccion("Quito");
		h3.setNombre("Hotel 3");
		//this.hotelService.insertarHotel(h3);
		
		
//		LOG.info("JOIN con tipo");
//		this.hotelService.buscarHotelInnerJoin("Normal").forEach(System.out::println);
//		LOG.info("JOIN -> SIN con tipo");
//		this.hotelService.buscarHotelInnerJoin().forEach(System.out::println);
//	
//		LOG.info("LEFT JOIN con tipo");
//	   this.hotelService.buscarHotelOuterJoinLeft("Normal").forEach(System.out::println);
//	   LOG.info("LEFT JOIN -> SIN con tipo");
//		this.hotelService.buscarHotelOuterJoinLeft().forEach(System.out::println);
//	
//		LOG.info("RIGHT JOIN");
//	   this.hotelService.buscarHotelOuterJoinRigth("Normal").forEach(System.out::println);
	
	
		System.out.println("------------------  TALLER 30 ----------------------");
//		LOG.info("JOIN WHERE ");
//		this.hotelService.buscarHotelJoinWhere("Matrimonial").forEach(System.out::println);
//	
//		LOG.info("INNER JOIN  EAGER/LAZY");
//		this.hotelService.buscarHotelInnerJoin("Matrimonial").forEach(System.out::println);
//		LOG.info("-->> Habitaciones");
//		
//		List<Hotel> ho = this.hotelService.buscarHotelInnerJoin("Matrimonial");
//		
//		for (Hotel item : ho) {
//			LOG.info("Habitaciones: "+item.getHabitaciones());
//		}
		
//		LOG.info("JOIN FETCH");
//		List<Hotel> ho2 =this.hotelService.buscarHotelJoinFetch("Matrimonial");
//		for (Hotel item : ho2) {
//			LOG.info("Habitaciones: "+item.getHabitaciones());
//		}
		
		System.out.println("----------------TALLER 31 -------------");
//		LOG.info("JOIN FETCH");
//		List<Hotel> ho2 =this.hotelService.buscarHotelJoinFetch("Matrimonial");
//		for (Hotel item : ho2) {
//			LOG.info("Habitaciones: "+item.getHabitaciones());
//		}
	
		CuentaBancaria c1 = new CuentaBancaria();
		c1.setNumero("A-111");
		c1.setSaldo(new BigDecimal(850));
		c1.setTipo("Ahorro");
		
		CuentaBancaria c2 = new CuentaBancaria();
		c2.setNumero("A-211");
		c2.setSaldo(new BigDecimal(450));
		c2.setTipo("Ahorro");
		
		//this.cuentaBancariaService.insertarCuentaBancaria(c1);
		//this.cuentaBancariaService.insertarCuentaBancaria(c2);
		
		//this.transferenciaService.realizarTransferencia("A-111", "A-211", new BigDecimal(20));
	
		//this.transferenciaService.realizarTransferenciaFachada("A-111", "A-211", new BigDecimal(5));
	
		System.out.println("----------------------- TALLER 32 -------------- ");
		//this.transferenciaService.realizarTransferenciaFachada("A-111", "A-211", new BigDecimal(5));
		
		
		System.out.println("-----------------------TAREA 31-------------- ");
		
		Cliente clie1 = new Cliente();
		clie1.setApellido("Morales");
		clie1.setCedula("1712134578");
		clie1.setDireccion("Quito");
		clie1.setNombre("Karla");
		
		
		Cliente clie2 = new Cliente();
		clie2.setApellido("Zanches");
		clie2.setCedula("1600102130");
		clie2.setDireccion("Quito");
		clie2.setNombre("Marco");
		
//		this.clienteService.insertarCliente(clie1);
//		this.clienteService.insertarCliente(clie2);
		
		
		Producto prod1 = new Producto();
		prod1.setCodigoBarra("100000001");
		prod1.setNombre("Avena");
		prod1.setPrecio(new BigDecimal(0.60));
		prod1.setStock(20);
		
		Producto prod2 = new Producto();
		prod2.setCodigoBarra("100000002");
		prod2.setNombre("Atun");
		prod2.setPrecio(new BigDecimal(0.90));
		prod2.setStock(30);
		
		
		Producto prod3 = new Producto();
		prod3.setCodigoBarra("100000003");
		prod3.setNombre("Aceite");
		prod3.setPrecio(new BigDecimal(6.00));
		prod3.setStock(40);
		
		Producto prod4 = new Producto();
		prod4.setCodigoBarra("100000004");
		prod4.setNombre("Cafe");
		prod4.setPrecio(new BigDecimal(3.00));
		prod4.setStock(15);
		
//		this.productoService.insertarProducto(prod1);
//		this.productoService.insertarProducto(prod2);
//		this.productoService.insertarProducto(prod3);
//		this.productoService.insertarProducto(prod4);
		
		
		List<String>codigosBarra = new ArrayList<>();
		
		codigosBarra.add("100000001");
		codigosBarra.add("100000002");
		codigosBarra.add("100000003");
		codigosBarra.add("100000004");
		
		this.gestorCompraService.generarFactura("000001271","1712134578" , codigosBarra);
		
	}

}
























