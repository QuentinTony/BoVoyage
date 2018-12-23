package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.model.Destination;

@Service("deService")
@Transactional
public class DestinationServiceImpl implements IDestinationService{
	
	private IDestinationDao deDao;

	
	@Autowired
	public void setDeDao(IDestinationDao deDao) {
		this.deDao = deDao;
		deDao.setGeneric(Destination.class);
	}

	@Override
	public Destination addDestination(Destination destination) {
		
		return deDao.add(destination);
	}

	@Override
	public List<Destination> getAllDestination() {
		
		return deDao.getAll();
	}

	@Override
	public Destination getDestination(long id) {
		
		return deDao.getById(id);
	}

	@Override
	public int deleteDestination(Destination destination) {
		
			deDao.delete(destination);
			return 1;
		
	
	}

	@Override
	public int updateDestination(Destination destination) {
		
		return deDao.update(destination);
	}
	
	
	
	

}
