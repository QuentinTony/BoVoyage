package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.service.IAgenceService;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/marketing")
public class MarketingController {
	@Autowired
	private IAgenceService agService;

	public void setAgService(IAgenceService agService) {
		this.agService = agService;
	}
	@Autowired
	private IClientService clService;

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	@RequestMapping(value="/listagence", method=RequestMethod.GET)
	public ModelAndView afficheListe() {
		//Récuperer la liste de la BD
		
		List<Client> listAgence= clService.getAllClient();
		return new ModelAndView("accueilMarketing","listclient",listAgence);
		
	}
	
	
}
