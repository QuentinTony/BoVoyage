package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;

@Repository
public class AgenceDaoImpl extends GenericDaoImpl<Agence> implements IAgenceDao{
	
	@Override
	public Agence isExistMark(Agence agIn) {
		
		return (Agence) em.createQuery("FROM Agence p WHERE p.mail=:pMail AND p.statut=:pStatut AND p.mdp=:pMdp")
		.setParameter("pMail", agIn.getMail())
		.setParameter("pMdp", agIn.getMdp()).setParameter("pStatut", agIn.getStatut()).getSingleResult();
		
	}
	
	@Override
	public Agence isExistGest(Agence agIn) {
		
		return (Agence) em.createQuery("FROM Agence p WHERE p.mail=:pMail AND p.statut=:pStatut AND p.mdp=:pMdp")
		.setParameter("pMail", agIn.getMail())
		.setParameter("pMdp", agIn.getMdp()).setParameter("pStatut", agIn.getStatut()).getSingleResult();
		
	}
	
	@Override
	public Agence isExistDir(Agence agIn) {
		
		return (Agence) em.createQuery("FROM Agence p WHERE p.mail=:pMail AND p.statut=:pStatut AND p.mdp=:pMdp")
		.setParameter("pMail", agIn.getMail())
		.setParameter("pMdp", agIn.getMdp()).setParameter("pStatut", agIn.getStatut()).getSingleResult();
		
	}

}
