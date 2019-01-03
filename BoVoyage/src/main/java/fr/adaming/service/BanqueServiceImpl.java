package fr.adaming.service;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import fr.adaming.model.Banque;

@Service("baService")
public class BanqueServiceImpl implements IBanqueService {

	public static final String uri = "http://localhost:8080/WebService/compte/";

	@Override
	public Banque virement(Banque b, Double somme) {
		// créer un client du web service
		ClientConfig config = new DefaultClientConfig();

		// autoriser la deserialisation des objets json en java pour jersey
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		// creer un client du web service restful
		Client clientWS = Client.create(config);

		// recuperer le bus qui va servir d'envoyer la requete et récuperer le résultat
		WebResource service = clientWS.resource(uri);

		// envoyer la requete et récuperer le resultat
		ClientResponse reponse = service.path("virement").queryParam("dSomme", Double.toString(somme))
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, b);
		System.out.println("j'ai lancé la méthode");
		Banque banque = reponse.getEntity(Banque.class);
		return banque;
	}

	@Override
	public Banque getCompte(long id) {
		// créer un client du web service
		ClientConfig config = new DefaultClientConfig();

		// autoriser la deserialisation des objets json en java pour jersey
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		// creer un client du web service restful
		Client clientWS = Client.create(config);

		// recuperer le bus qui va servir d'envoyer la requete et récuperer le résultat
		WebResource service = clientWS.resource(uri);

		// envoyer la requete et récuperer le resultat
		ClientResponse reponse = service.path("get").queryParam("idB", Long.toString(id))
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);

		Banque banque = reponse.getEntity(Banque.class);
		return banque;
	}

	@Override
	public Banque verif(Banque b) {
		// créer un client du web service
				ClientConfig config = new DefaultClientConfig();

				// autoriser la deserialisation des objets json en java pour jersey
				config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

				// creer un client du web service restful
				Client clientWS = Client.create(config);

				// recuperer le bus qui va servir d'envoyer la requete et récuperer le résultat
				WebResource service = clientWS.resource(uri);

				// envoyer la requete et récuperer le resultat
				ClientResponse reponse = service.path("verif")
						.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON)
						.post(ClientResponse.class, b);
				System.out.println("j'ai lancé la méthode");
				Banque banque = reponse.getEntity(Banque.class);
				
				Banque b2=reponse.getEntity(Banque.class);
		return b2;
	}

	

}
