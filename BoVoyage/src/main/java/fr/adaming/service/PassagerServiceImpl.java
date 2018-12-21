package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.dao.IPassagerDao;
import fr.adaming.model.Passager;

@Service("paService")
@Transactional
public class PassagerServiceImpl implements IPassagerService {
	
	private IPassagerDao paDao;
	
	@Autowired
	public void setPaDao(IPassagerDao paDao) {
		this.paDao = paDao;
	}

	@Override
	public Passager addPassager(Passager passager) {
		
		return paDao.add(passager);
	}

	@Override
	public List<Passager> getAllPassager() {
		
		return paDao.getAll();
	}

	@Override
	public Passager getPassager(long id) {
		
		return paDao.getById(id);
	}

	@Override
	public int deletePassager(Passager passager) {
		try {
			paDao.delete(passager);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
		
	}

	@Override
	public int updatePassager(Passager passager) {
		
		return paDao.update(passager);
	}

	@Override
	public List<Passager> getAllPassagerByIdClient(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
