package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Assurance;



public interface IAssuranceService {
	
	public Assurance addAssurance(Assurance assurance);
	
	public List<Assurance> getAllAssurance();

	public Assurance getAssurance(long id);

	public int deleteAssurance(Assurance assurance);

	public int updateAssurance(Assurance assurance);

}
