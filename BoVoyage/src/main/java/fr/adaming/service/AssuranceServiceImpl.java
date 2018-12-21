package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAssuranceDao;
import fr.adaming.model.Assurance;
import fr.adaming.model.Destination;

@Service("asService") 
@Transactional
public class AssuranceServiceImpl implements IAssuranceService {
	
	private IAssuranceDao asDao;
	
	@Autowired
	public void setAsDao(IAssuranceDao asDao) {
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
		try {
			asDao.delete(assurance);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
		
	}

	@Override
	public int updateAssurance(Assurance assurance) {
		
		return asDao.update(assurance);
	}

}
