package fr.adaming.service;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;
import fr.adaming.model.Destination;

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService{
	
	private IClientDao clDao;
	
	@Autowired
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
		clDao.setGeneric(Client.class);
	}



	@Override
	public Client addClient(Client client) {
		
		return clDao.add(client);
	}

	

	@Override
	public List<Client> getAllClient() {
		
		return clDao.getAll();
	}

	@Override
	public Client getClient(long id) {
		
		return clDao.getById(id);
	}

	@Override
	public int deleteClient(Client client) {
		try {
			clDao.delete(client);
			return 1;
		}catch (Exception ex) {
			return 0;
		}
	}

	@Override
	public int updateClient(Client client) {
		
		return clDao.update(client);
	}



	// METHODE VIREMENT, paiement du voyage par le client (fonctionnalité cliente du WS Banque)
	
	public static final String uri = "http://localhost:8080/TP_TransportCargaison_WebServicee/banque/virement/111/";//36847491/516/500
	
	@Override
	public int virement(Client client, double prix) {
		// Créer un client du web service
		ClientConfig config = new DefaultClientConfig();

		// autoriser la deserialisation des objets json en java pour jersey
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		// creer un client du web service RestFul
		com.sun.jersey.api.client.Client clientWS = com.sun.jersey.api.client.Client.create(config);

		// construire l'url du web service

		// recuperer le bus qui va servir d'envoyer la requete et récuperer le résultat
		WebResource service = clientWS.resource(uri);

		// envoyer la requete et récuperer le resultat
		ClientResponse reponse = service.path(Long.toString(client.getNumeroCarte()) + "/" + Integer.toString(client.getCleSecurite()) 
				+ "/" + Double.toString(prix))
				.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		
		return reponse.getEntity(Integer.class);
	
	}
	
	
	
	
	


}
