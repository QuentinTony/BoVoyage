package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Passager;


public interface IPassagerService {

	public Passager addPassager(Passager passager);
	
	public List<Passager> getAllPassager();

	public Passager getPassager(long id);

	public int deletePassager(Passager passager);

	public int updatePassager(Passager passager);
	
	public List<Passager> getAllPassagerByIdClient(long id);
	
}
