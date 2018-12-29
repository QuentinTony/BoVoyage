package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Prestation;

public interface IPrestationService {
	
	public Prestation addPrestation(Prestation prestation);
	
	public List<Prestation> getAllPrestation();

	public Prestation getPrestation(long id);

	public int deletePrestation(Prestation prestation);

	public int updatePrestation(Prestation prestation);
	
	public List<Prestation> getAllByDestination(long id);


}
