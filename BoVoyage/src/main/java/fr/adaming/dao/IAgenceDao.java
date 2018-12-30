package fr.adaming.dao;

import fr.adaming.model.Agence;

public interface IAgenceDao extends IGenericDao<Agence>{
	
	public Agence isExistMark(Agence agIn);
	
	public Agence isExistGest(Agence agIn);

	public Agence isExistDir(Agence agIn);



}
