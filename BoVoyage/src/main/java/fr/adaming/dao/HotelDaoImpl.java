package fr.adaming.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;

@Repository
public class HotelDaoImpl extends GenericDaoImpl<Hotel> implements IHotelDao{

	@Override
	public List<Hotel> getAllByDestination(long id) {
		System.out.println();
		return  em.createQuery("SELECT h FROM Hotel h WHERE h.destination.id=:id").setParameter("id", id).getResultList();
		}

}
