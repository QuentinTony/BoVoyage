package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Hotel;

public interface IHotelDao extends IGenericDao<Hotel>{
	
	public List<Hotel> getAllByDestination(long id);


}
