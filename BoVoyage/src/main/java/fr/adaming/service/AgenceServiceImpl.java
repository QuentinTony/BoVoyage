package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;

@Service("agService")
@Transactional
public class AgenceServiceImpl implements IAgenceService{
	
	private IAgenceDao agDao;

	
	@Autowired
	public void setAgDao(IAgenceDao agDao) {
		this.agDao = agDao;
	}

	@Override
	public Agence addAgence(Agence agence) {
		
		return agDao.add(agence);
	}

	@Override
	public List<Agence> getAllAgence() {
		
		return agDao.getAll();
	}

	@Override
	public Agence getAgence(long id) {
		
		return agDao.getById(id);
	}

	@Override
	public int deleteAgence(Agence agence) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAgence(Agence agence) {
		
		return agDao.update(agence);
	}

}
