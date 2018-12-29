package fr.adaming.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;
import fr.adaming.model.Prestation;

@Repository
public class PrestationDaoImpl extends GenericDaoImpl<Prestation> implements IPrestationDao{
	
	@Override
	public List<Prestation> getAllByDestination(long id) {
		System.out.println();
		return  em.createQuery("SELECT h FROM Prestation h WHERE h.destination.id=:id").setParameter("id", id).getResultList();
		}

}
