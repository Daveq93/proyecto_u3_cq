package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repo.IHotelRepo;
import com.uce.edu.repo.modelo.Hotel;



@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepo hotelRepo;
	
	@Override
	public void insertarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepo.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelInnerJoin(tipo);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinLeft(tipo);
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinRigth(tipo);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelJoinWhere(tipo);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelJoinFetch(tipo);
	}

	

	

}
