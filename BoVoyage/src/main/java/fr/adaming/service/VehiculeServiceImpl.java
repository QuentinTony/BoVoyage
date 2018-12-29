package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenericDao;
import fr.adaming.dao.IVehiculeDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Hotel;
import fr.adaming.model.Vehicule;

@Service("veService")
@Transactional
public class VehiculeServiceImpl implements IVehiculeService{
	
	private IVehiculeDao veDao;
	
	@Autowired
	public void setVeDao(IVehiculeDao veDao) {
		this.veDao = veDao;
		veDao.setGeneric(Vehicule.class);
	}

	@Override
	public Vehicule addVehicule(Vehicule vehicule) {
		
		return veDao.add(vehicule);
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		
		return veDao.getAll();
	}

	@Override
	public Vehicule getVehicule(long id) {
		
		return veDao.getById(id);
	}

	@Override
	public int deleteVehicule(Vehicule vehicule) {
	
			veDao.delete(vehicule);
			return 1;
		
	}

	@Override
	public int updateVehicule(Vehicule vehicule) {
		
		return veDao.update(vehicule);
	}
	
	@Override
	public List<Vehicule> getAllByDestination(long id) {
		System.out.println("Service");

		return veDao.getAllByDestination(id);
	}
	

}
