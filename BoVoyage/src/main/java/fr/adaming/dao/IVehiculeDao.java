package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Vehicule;

public interface IVehiculeDao extends IGenericDao<Vehicule>{
	
	public List<Vehicule> getAllByDestination(long id);


}
