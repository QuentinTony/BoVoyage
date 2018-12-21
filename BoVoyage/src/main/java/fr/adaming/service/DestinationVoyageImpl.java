package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Destination;

@Service("deService")
@Transactional
public class DestinationVoyageImpl implements IDestinationService{
	
	private IGenericDao<Destination> deDao;

	@Autowired
	public void setDeDao(IGenericDao<Destination> deDao) {
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
	public Destination getHotel(long id) {
		
		return deDao.getById(id);
	}

	@Override
	public int deleteDestination(Destination destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDestination(Destination destination) {
		
		return deDao.update(destination);
	}
	
	
	
	

}
