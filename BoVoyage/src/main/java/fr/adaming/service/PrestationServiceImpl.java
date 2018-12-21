package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.dao.IPrestationDao;
import fr.adaming.model.Prestation;

@Service("prService")
@Transactional
public class PrestationServiceImpl implements IPrestationService{
	
	private IPrestationDao prDao;

	
	@Autowired
	public void setPrDao(IPrestationDao prDao) {
		this.prDao = prDao;
	}

	@Override
	public Prestation addPrestation(Prestation prestation) {
		
		return prDao.add(prestation);
	}

	@Override
	public List<Prestation> getAllPrestation() {
		
		return prDao.getAll();
	}

	@Override
	public Prestation getPrestation(long id) {
		
		return prDao.getById(id);
	}

	@Override
	public int deletePrestation(Prestation prestation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePrestation(Prestation prestation) {
		
		return prDao.update(prestation);
	}
	
	
	
 
}
