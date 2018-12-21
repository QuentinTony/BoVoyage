package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Destination;



public interface IDestinationService {
	
public Destination addDestination(Destination destination);
	
	public List<Destination> getAllDestination();

	public Destination getHotel(long id);

	public int deleteDestination(Destination destination);

	public int updateDestination(Destination destination);

}
