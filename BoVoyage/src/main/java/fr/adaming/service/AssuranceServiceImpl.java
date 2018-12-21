package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.model.Assurance;

@Service("asService")
@Transactional
public class AssuranceServiceImpl implements IAssuranceService {
	
	private IGenericDao<Assurance> asDao;
	
	
	@Autowired
	public void setAsDao(IGenericDao<Assurance> asDao) {
		this.asDao = asDao;
		asDao.setGeneric(Assurance.class);
	}

	@Override
	public Assurance addAssurance(Assurance assurance) {
		
		return asDao.add(assurance);
	}

	@Override
	public List<Assurance> getAllAssurance() {
		
		return asDao.getAll();
	}

	@Override
	public Assurance getAssurance(long id) {
		
		return asDao.getById(id);
	}

	@Override
	public int deleteAssurance(Assurance assurance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAssurance(Assurance assurance) {
		
		return asDao.update(assurance);
	}

}
