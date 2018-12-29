package fr.adaming.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao{
	
	@Override
	public Client isExist(Client clIn) {
		
		return (Client) em.createQuery("FROM Client p WHERE p.mail=:pMail AND p.mdp=:pMdp")
		.setParameter("pMail", clIn.getMail())
		.setParameter("pMdp", clIn.getMdp()).getSingleResult();
		
	
		
	}

}
