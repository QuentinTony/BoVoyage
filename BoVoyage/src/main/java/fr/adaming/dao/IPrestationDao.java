package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Prestation;

public interface IPrestationDao extends IGenericDao<Prestation>{
	
	public List<Prestation> getAllByDestination(long id);


}
