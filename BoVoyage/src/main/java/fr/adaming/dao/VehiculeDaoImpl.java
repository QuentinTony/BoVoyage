package fr.adaming.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;
import fr.adaming.model.Vehicule;

@Repository
public class VehiculeDaoImpl extends GenericDaoImpl<Vehicule> implements IVehiculeDao{
	
	@Override
	public List<Vehicule> getAllByDestination(long id) {
		System.out.println();
		return  em.createQuery("SELECT h FROM Vehicule h WHERE h.destination.id=:id").setParameter("id", id).getResultList();
		}

}
