package com.uce.edu.repo;

import java.util.List;

import com.uce.edu.repo.modelo.Hotel;

public interface IHotelRepo {

	
	void insertar(Hotel hotel);
	
	Hotel buscarPorId(Integer id);
	
	List<Hotel> buscarHotelInnerJoin(String tipo);
	
	List<Hotel> buscarHotelInnerJoin();
	
	List<Hotel> buscarHotelOuterJoinLeft(String tipo);
	
	List<Hotel> buscarHotelOuterJoinLeft();
	
	List<Hotel> buscarHotelOuterJoinRigth(String tipo);
	
	List<Hotel> buscarHotelJoinWhere(String tipo);
	
	List<Hotel> buscarHotelJoinFetch(String tipo);
	
	
}
