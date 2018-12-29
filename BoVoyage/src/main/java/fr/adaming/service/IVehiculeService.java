package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Vehicule;

public interface IVehiculeService {
	
	public Vehicule addVehicule(Vehicule vehicule);
	
	public List<Vehicule> getAllVehicule();

	public Vehicule getVehicule(long id);

	public int deleteVehicule(Vehicule vehicule);

	public int updateVehicule(Vehicule vehicule);
	
	public List<Vehicule> getAllByDestination(long id);


}
