package fr.adaming.service;

import java.util.Date;
import java.util.List;

import fr.adaming.model.Assurance;
import fr.adaming.model.Hotel;
import fr.adaming.model.Passager;
import fr.adaming.model.Vehicule;
import fr.adaming.model.Voyage;

public interface IVoyageService {

	public Voyage addVoyage(Voyage voyage);

	public List<Voyage> getAllVoyage();

	public Voyage getVoyage(long id);

	public int deleteVoyage(Voyage voyage);

	public int updateVoyage(Voyage voyage);

	public List<Voyage> getVoyageByPrix(double prix);

	public List<Voyage> getVoyageByContinent(String cont);

	public List<Voyage> getVoyageByPays(String pays);

	public List<Voyage> getVoyageByDateDepart(Date dd);

	public List<Voyage> getVoyageByDateRetour(Date dr);

	public List<Voyage> getVoyageByDateDepRet(Date dd, Date dr);

	public List<Voyage> getVoyageByMonth(int m);
	
	public int setHotel(Hotel ho, Voyage vo);
	
	public int setVehicule(Vehicule ve, Voyage vo);
	
	public int setAssurance(Assurance as, Voyage vo);
	
	public int setPassager(List<Passager> pa, Voyage vo);

}
