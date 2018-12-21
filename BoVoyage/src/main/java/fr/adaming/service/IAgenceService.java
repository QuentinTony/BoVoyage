package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Agence;


public interface IAgenceService {
	
	public Agence addAgence(Agence agence);

	public List<Agence> getAllAgence();

	public Agence getAgence(long id);

	public int deleteAgence(Agence agence);

	public int updateAgence(Agence agence);

}
