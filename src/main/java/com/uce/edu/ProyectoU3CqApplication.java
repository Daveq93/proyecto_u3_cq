package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repo.modelo.Habitacion;
import com.uce.edu.repo.modelo.Hotel;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class ProyectoU3CqApplication implements CommandLineRunner{
	private static Logger LOG = Logger.getLogger(ProyectoU3CqApplication.class);
	
	@Autowired
	private IHotelService hotelService;
	
	
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
		LOG.info("JOIN WHERE ");
		this.hotelService.buscarHotelJoinWhere("Matrimonial").forEach(System.out::println);
	
		LOG.info("INNER JOIN  EAGER/LAZY");
		this.hotelService.buscarHotelInnerJoin("Matrimonial").forEach(System.out::println);
		LOG.info("-->> Habitaciones");
		
		List<Hotel> ho = this.hotelService.buscarHotelInnerJoin("Matrimonial");
		
		for (Hotel item : ho) {
			LOG.info("Habitaciones: "+item.getHabitaciones());
		}
		
		LOG.info("JOIN FETCH");
		List<Hotel> ho2 =this.hotelService.buscarHotelJoinFetch("Matrimonial");
		for (Hotel item : ho2) {
			LOG.info("Habitaciones: "+item.getHabitaciones());
		}
	}

}
