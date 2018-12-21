package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.model.Destination;

@Service("deService")
@Transactional
public class DestinationVoyageImpl implements IDestinationService{
	
	private IDestinationDao deDao;

	
	@Autowired
	public void setDeDao(IDestinationDao deDao) {
		this.deDao = deDao;
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
		try {
			deDao.delete(destination);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
	
	}

	@Override
	public int updateDestination(Destination destination) {
		
		return deDao.update(destination);
	}
	
	
	
	

}
