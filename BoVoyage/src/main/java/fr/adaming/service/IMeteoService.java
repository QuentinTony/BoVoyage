package fr.adaming.service;

import fr.adaming.model.Meteo;

public interface IMeteoService {
	
	public Meteo infosMeteo(String lat, String longitude);

}
