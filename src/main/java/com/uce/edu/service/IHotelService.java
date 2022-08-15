package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repo.modelo.Hotel;

public interface IHotelService {

	boolean insertarHotel(Hotel hotel);

	List<Hotel> buscarHotelInnerJoin(String tipo);
	
	List<Hotel> buscarHotelInnerJoin();

	List<Hotel> buscarHotelOuterJoinLeft(String tipo);
	
	List<Hotel> buscarHotelOuterJoinLeft();

	List<Hotel> buscarHotelOuterJoinRigth(String tipo);

	List<Hotel> buscarHotelJoinWhere(String tipo);

	List<Hotel> buscarHotelJoinFetch(String tipo);
}
