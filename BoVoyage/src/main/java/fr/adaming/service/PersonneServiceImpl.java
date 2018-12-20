package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Personne;

@Service("peService")
@Transactional
public class PersonneServiceImpl implements IPersonneService{
	
	private IGenericDao<Personne> peDao;
	
	
	@Autowired
	public void setPeDao(IGenericDao<Personne> peDao) {
		this.peDao = peDao;
		peDao.setGeneric(Personne.class);
	}

	@Override
	public Personne addPersonne(Personne personne) {
		
		return peDao.add(personne);
	}

	@Override
	public List<Personne> getAllPersonne() {
		
		return peDao.getAll();
	}

	@Override
	public Personne getPersonne(long id) {
		
		return peDao.getById(id);
	}

	@Override
	public int deletePersonne(Personne personne) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonne(Personne personne) {
		
		return peDao.update(personne);
	};

}
