package fr.adaming.service;

import fr.adaming.model.Banque;

public interface IBanqueService {
	
	public Banque virement(Banque b, Double somme);
	
	public Banque getCompte(long id);
	
	public Banque verif(Banque b);
	
	

}
