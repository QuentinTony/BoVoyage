package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	public Client addClient(Client client);
	
	public List<Client> getAllClient();

	public Client getClient(long id);

	public int deleteClient(Client client);

	public int updateClient(Client client);
	
	public int virement(Client client, double prix);
	
	public Client isExist(Client clIn);

	

}
