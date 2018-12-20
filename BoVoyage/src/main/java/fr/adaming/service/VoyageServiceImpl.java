package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Voyage;

@Service("voService")
@Transactional
public class VoyageServiceImpl implements IVoyageService {
	
	
	private IGenericDao<Voyage> voDao;
	
	

	@Autowired
	public void setVoDao(IGenericDao<Voyage> voDao) {
		this.voDao = voDao;
		voDao.setGeneric(Voyage.class);
	}

	@Override
	public Voyage addVoyage(Voyage voyage) {
		
		return voDao.add(voyage);
	}

	@Override
	public List<Voyage> getAllVoyage() {
		
		return voDao.getAll();
	}

	@Override
	public Voyage getVoyage(int id) {
		
		return voDao.getById(id);
	}

	@Override
	public int deleteVoyage(Voyage voyage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateVoyage(Voyage voyage) {
		
		return voDao.update(voyage);
	}

}
