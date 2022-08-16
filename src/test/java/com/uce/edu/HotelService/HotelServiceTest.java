package com.uce.edu.HotelService;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.math.BigDecimal;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.repo.IHotelRepo;
import com.uce.edu.repo.modelo.CuentaBancaria;
import com.uce.edu.repo.modelo.Habitacion;
import com.uce.edu.repo.modelo.Hotel;
import com.uce.edu.service.ICuentaBancariaService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ITransferenciaService;


@SpringBootTest
public class HotelServiceTest {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IHotelRepo hotelRepo;


	 //@Test
	public void insertarHotel() {
		Hotel h1 = new Hotel();
		//h1.setId(1);
		h1.setDireccion("Quevedo");
		h1.setNombre("Q-Hotel");

		 //assertEquals(true, this.hotelService.insertarHotel(h1));
		// assertTrue(this.hotelService.insertarHotel(h1));
	}

	//@Test
	public void testHabitaciones() {

		Hotel h1 = this.hotelRepo.buscarPorId(1);
		Hotel h2 = this.hotelRepo.buscarPorId(2);
		Hotel h3 = this.hotelRepo.buscarPorId(3);
		Hotel h4 = this.hotelRepo.buscarPorId(4);

		assertTrue(h1.getHabitaciones().size() > 0);
		assertTrue(h2.getHabitaciones().size() > 0);
		// assertTrue(h3.getHabitaciones().size()> 0);
		// assertTrue(h4.getHabitaciones().size()>0);

		assertNotSame(h1, h2);
		assertNotSame(h1, h3);
		assertNotSame(h1, h4);
		
		

		assertInstanceOf(Habitacion.class, h1.getHabitaciones().get(0));
		assertInstanceOf(Habitacion.class, h1.getHabitaciones().get(1));
		assertInstanceOf(Habitacion.class, h1.getHabitaciones().get(2));

		assertThat(h1.getHabitaciones(), hasSize(3));
		assertThat(h1.getHabitaciones(), not(IsEmptyCollection.empty()));

		assertThat(h2.getHabitaciones(), hasSize(3));
		assertThat(h2.getHabitaciones(), not(IsEmptyCollection.empty()));

		assertThat(h3.getHabitaciones(), is(IsEmptyCollection.empty()));
		assertThat(h4.getHabitaciones(), is(IsEmptyCollection.empty()));

	}

	
	
	
	
}
