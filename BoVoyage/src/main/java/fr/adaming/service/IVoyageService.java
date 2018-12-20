package fr.adaming.service;

import java.util.List;


import fr.adaming.model.Voyage;

public interface IVoyageService {
	
	public Voyage addVoyage(Voyage voyage);
	
	public List<Voyage> getAllVoyage();

	public Voyage getVoyage(int id);

	public int deleteVoyage(Voyage voyage);

	public int updateVoyage(Voyage voyage);
	

}
