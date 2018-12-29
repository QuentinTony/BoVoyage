package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleService {
	
	public Formule addFormule(Formule formule);

	public List<Formule> getAllFormule();

	public Formule getFormule(long id);

	public int deleteFormule(Formule formule);

	public int updateFormule(Formule formule);

}
