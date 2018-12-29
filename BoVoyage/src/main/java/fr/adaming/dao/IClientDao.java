package fr.adaming.dao;

import fr.adaming.model.Client;

public interface IClientDao extends IGenericDao<Client>{

	public Client isExist(Client clIn);

}
