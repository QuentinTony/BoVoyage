package fr.adaming.service;

import java.time.Month;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;

@Service("voService")
@Transactional
public class VoyageServiceImpl implements IVoyageService {
	
	
	private IVoyageDao voDao;
	
	private IDestinationDao deDao;
	
	@Autowired
	public void setDeDao(IDestinationDao deDao) {
		
		this.deDao = deDao;
		deDao.setGeneric(Destination.class);
	}

	@Autowired
	public void setVoDao(IVoyageDao voDao) {
		this.voDao = voDao;
		voDao.setGeneric(Voyage.class);
	}

	@Override
	public Voyage addVoyage(Voyage voyage) {
		
		return voDao.add(voyage);
	}

	@Override
	public List<Voyage> getAllVoyage() {
		List<Voyage> liste=voDao.getAll();
		
//		for(Voyage vo: liste) {
//			Destination de=deDao.getById(vo.getDestination().getId());
//			vo.setDestination(de);
//		}
		return liste;
	}

	@Override
	public Voyage getVoyage(long id) {
		
		return voDao.getById(id);
	}

	@Override
	public int deleteVoyage(Voyage voyage) {
		try {
			voDao.delete(voyage);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public int updateVoyage(Voyage voyage) {
		
		return voDao.update(voyage);
	}
	
	// methodes spécifiques pour rechercher la liste

	@Override
	public List<Voyage> getVoyageByPrix(double prix) {
		
		return voDao.getVoyageByPrix(prix);
	}

	@Override
	public List<Voyage> getVoyageByContinent(String cont) {
		
		return voDao.getVoyageByContinent(cont);
	}

	@Override
	public List<Voyage> getVoyageByPays(String pays) {
		
		return voDao.getVoyageByPays(pays);
	}

	@Override
	public List<Voyage> getVoyageByDateDepart(Date dd) {
		
		return voDao.getVoyageByDateDepart(dd);
	}

	@Override
	public List<Voyage> getVoyageByDateRetour(Date dr) {
	
		return voDao.getVoyageByDateRetour(dr);
	}

	@Override
	public List<Voyage> getVoyageByDateDepRet(Date dd, Date dr) {
	
		return voDao.getVoyageByDateDepRet(dd, dr);
	}

	@Override
	public List<Voyage> getVoyageByMonth(int m) {
		List<Voyage> liste=voDao.getAll();
		for (Voyage vo : liste) {
			int mOut=vo.getDateDepart().getMonth();
			if(mOut!=m) {
				liste.remove(vo);
			}
		}
		return liste;
	}
	
	
	

}
