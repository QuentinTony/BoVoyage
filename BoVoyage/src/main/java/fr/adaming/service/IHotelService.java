package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hotel;


public interface IHotelService {
	
	public Hotel addHotel(Hotel hotel);
	
	public List<Hotel> getAllHotel();

	public Hotel getHotel(long id);

	public int deleteHotel(Hotel hotel);

	public int updateHotel(Hotel hotel);
	
	public List<Hotel> getAllByDestination(long id);



}
