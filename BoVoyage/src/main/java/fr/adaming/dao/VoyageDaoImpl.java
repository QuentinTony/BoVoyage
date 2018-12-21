package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl extends GenericDaoImpl<Voyage> implements IVoyageDao {

	@Autowired
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Voyage> getVoyageByPrix(double prix) {
		EntityManager em = emf.createEntityManager();
		String req = "FROM Voyage v WHERE v.prix<=:pPrix";
		Query q = em.createQuery(req);
		q.setParameter("pPrix", prix);
		//
		return q.getResultList();
	}

	@Override
	public List<Voyage> getVoyageByContinent(String cont) {
		EntityManager em = emf.createEntityManager();
		String req = "FROM Voyage v WHERE v.destination.continent LIKE :pCont";
		Query q = em.createQuery(req);
		q.setParameter("pCont", "%" + cont + "%");
		return q.getResultList();
	}

	@Override
	public List<Voyage> getVoyageByDateDepart(Date dd) {
		EntityManager em = emf.createEntityManager();
		String req = "FROM Voyage v WHERE v.dateDepart=:pDate";
		Query q = em.createQuery(req);
		q.setParameter("pDate", dd);
		return q.getResultList();
	}

	@Override
	public List<Voyage> getVoyageByDateRetour(Date dr) {
		EntityManager em = emf.createEntityManager();
		String req = "FROM Voyage v WHERE v.dateRetour=:pDate";
		Query q = em.createQuery(req);
		q.setParameter("pDate", dr);
		return q.getResultList();
	}

	@Override
	public List<Voyage> getVoyageByDateDepRet(Date dd, Date dr) {
		EntityManager em = emf.createEntityManager();
		String req = "FROM Voyage v WHERE v.dateDepart=:pDateD AND v.dateRetou=:pDateR";
		Query q = em.createQuery(req);
		q.setParameter("pDateD", dd);
		q.setParameter("pDateR", dr);
		return q.getResultList();
	}

	@Override
	public List<Voyage> getVoyageByPays(String pays) {
		EntityManager em = emf.createEntityManager();
		String req = "FROM Voyage v WHERE v.destination.pays LIKE :pPays";
		Query q = em.createQuery(req);
		q.setParameter("pPays", "%" + pays + "%");
		return q.getResultList();
	}

}
