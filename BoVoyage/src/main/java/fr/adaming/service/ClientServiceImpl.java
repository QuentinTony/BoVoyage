package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Client;

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService{
	
	private IGenericDao<Client> clDao;
	
	
	@Autowired
	public void setClDao(IGenericDao<Client> clDao) {
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
		
		return 0;
	}

	@Override
	public int updateClient(Client client) {
		
		return clDao.update(client);
	}
	


}
