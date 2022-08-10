package com.uce.edu.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.repo.HotelRepoImpl;
import com.uce.edu.repo.IHotelRepo;
import com.uce.edu.repo.modelo.Hotel;



@Service
public class HotelServiceImpl implements IHotelService {
	private static Logger LOG = Logger.getLogger(HotelServiceImpl.class);
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
		LOG.debug("Transaccion activa SERVICE : "+TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepo.buscarHotelJoinFetch(tipo);
	}

	

	

}
