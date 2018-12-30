package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;
import fr.adaming.model.Destination;

@Service("agService")
@Transactional
public class AgenceServiceImpl implements IAgenceService {

	private IAgenceDao agDao;

	@Autowired
	public void setAgDao(IAgenceDao agDao) {
		this.agDao = agDao;
		agDao.setGeneric(Agence.class);
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
		agDao.delete(agence);
		return 1;
	}

	@Override
	public int updateAgence(Agence agence) {

		return agDao.update(agence);
	}

	@Override
	public Agence isExistMark(Agence agIn) {
		return agDao.isExistMark(agIn);
	}

	@Override
	public Agence isExistGest(Agence agIn) {
		return agDao.isExistGest(agIn);
	}

	@Override
	public Agence isExistDir(Agence agIn) {
		return agDao.isExistDir(agIn);
	}

}
