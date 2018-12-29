package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormuleDao;
import fr.adaming.model.Formule;

@Service("foService")
@Transactional
public class FormuleServiceImpl implements IFormuleService {

	private IFormuleDao foDao;

	@Autowired
	public void setDeDao(IFormuleDao foDao) {
		this.foDao = foDao;
		foDao.setGeneric(Formule.class);
	}

	@Override
	public Formule addFormule(Formule formule) {
		return foDao.add(formule);
	}

	@Override
	public List<Formule> getAllFormule() {
		return foDao.getAll();
	}

	@Override
	public Formule getFormule(long id) {
		return foDao.getById(id);
	}

	@Override
	public int deleteFormule(Formule formule) {
		foDao.delete(formule);
		return 1;
	}

	@Override
	public int updateFormule(Formule formule) {
		return foDao.update(formule);
	}

}
