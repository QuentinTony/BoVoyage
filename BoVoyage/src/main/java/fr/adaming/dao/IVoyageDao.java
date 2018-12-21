package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import fr.adaming.model.Voyage;

public interface IVoyageDao extends IGenericDao<Voyage>{

	public List<Voyage> getVoyageByPrix(double prix);
	public List<Voyage> getVoyageByContinent(String cont);
	public List<Voyage> getVoyageByPays(String pays);
	public List<Voyage> getVoyageByDateDepart(Date dd);
	public List<Voyage> getVoyageByDateRetour(Date dr);
	public List<Voyage> getVoyageByDateDepRet(Date dd, Date dr);
}
