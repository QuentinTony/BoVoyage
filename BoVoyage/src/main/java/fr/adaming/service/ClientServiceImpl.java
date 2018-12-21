package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;
import fr.adaming.model.Destination;

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService{
	
	private IClientDao clDao;
	
	@Autowired
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
		clDao.setGeneric(Client.class);
	}



	@Override
	public Client addClient(Client client) {
		
		return clDao.add(client);
	}

	

	@Override
	public List<Client> getAllClient() {
		
		return clDao.getAll();
	}

	@Override
	public Client getClient(long id) {
		
		return clDao.getById(id);
	}

	@Override
	public int deleteClient(Client client) {
		try {
			clDao.delete(client);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public int updateClient(Client client) {
		
		return clDao.update(client);
	}
	


}
