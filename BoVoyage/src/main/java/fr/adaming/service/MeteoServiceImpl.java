package fr.adaming.service;

import javax.ws.rs.core.MediaType;


import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import fr.adaming.model.Meteo;

@Service("meService")
public class MeteoServiceImpl implements IMeteoService {

	public static final String uri = "http://api.openweathermap.org/data/2.5/weather";

	@Override
	public Meteo infosMeteo(String lat, String longitude) {
		// créer un client du web service
		ClientConfig config = new DefaultClientConfig();

		// autoriser la deserialisation des objets json en java pour jersey
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		// creer un client du web service restful
		Client clientWS = Client.create(config);

		// recuperer le bus qui va servir d'envoyer la requete et récuperer le résultat
		WebResource service = clientWS.resource(uri);

		String appi = "70279082f45d93012e164631aa214d50";

		ClientResponse reponse = service.queryParam("lat", lat).queryParam("lon", longitude).queryParam("appid", appi)
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML).type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);

		Meteo meteo=reponse.getEntity(Meteo.class);
		
		meteo.toString();
		meteo.getMain().getTemp();
		
		return meteo;
	}

}
