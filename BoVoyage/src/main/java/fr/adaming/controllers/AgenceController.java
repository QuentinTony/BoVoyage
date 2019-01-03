package fr.adaming.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Agence;

import fr.adaming.model.Destination;
import fr.adaming.model.Hotel;
import fr.adaming.model.Prestation;
import fr.adaming.model.Vehicule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAgenceService;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IHotelService;

import fr.adaming.service.IPrestationService;
import fr.adaming.service.IVehiculeService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/agence")
public class AgenceController {
	
	@Autowired
	private IAgenceService agService;

	public void setAgService(IAgenceService agService) {
		this.agService = agService;
	}
	
	
	@Autowired
	private IVoyageService voService;
	@Autowired
	private IDestinationService deService;
	@Autowired
	private IHotelService hoService;
	@Autowired
	private IAssuranceService asService;
	@Autowired
	private IVehiculeService veService;
	@Autowired
	private IPrestationService prService;
	@Autowired
	private IClientService clService;

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	public void setDeService(IDestinationService deService) {
		this.deService = deService;
	}

	public void setHoService(IHotelService hoService) {
		this.hoService = hoService;
	}

	public void setAsService(IAssuranceService asService) {
		this.asService = asService;
	}

	public void setVeService(IVehiculeService veService) {
		this.veService = veService;
	}

	public void setPrService(IPrestationService prService) {
		this.prService = prService;
	}

	public void setVoService(IVoyageService voService) {
		this.voService = voService;
	}
	
	@RequestMapping(value="/listagence", method=RequestMethod.GET)
	public ModelAndView afficheListe() {
		//Récuperer la liste de la BD
		
		List<Agence> listAgence= agService.getAllAgence();
		return new ModelAndView("accueilAgence","listagence",listAgence);
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficheLogin() {
	
		return "loginagence";
	}

	

	
	@RequestMapping(value="/recherche", method=RequestMethod.GET)
	public String recherche(Model model) {
		//Recuperer l'identifiant de l'admin a partir du context de spring security
				Authentication auth= SecurityContextHolder.getContext().getAuthentication();
				//Recuperer l'identifiant
				
				String mail= auth.getName();
				model.addAttribute("identifiant",mail);
				model.addAttribute("msg", "Bonjour M. Client. Vous êtes dans votre PortailClient");
		List<Voyage> listvoyage = voService.getAllVoyage();
		model.addAttribute("listvoyage", listvoyage);
		model.addAttribute("voyage", new Voyage());
		List<Destination> listdestination = deService.getAllDestination();
		model.addAttribute("listdestination", listdestination);
		model.addAttribute("destination", new Destination());
		List<Hotel> listhotel = hoService.getAllHotel();
		model.addAttribute("listhotel", listhotel);
		model.addAttribute("hotel", new Hotel());
		List<Vehicule> listvehicule = veService.getAllVehicule();
		model.addAttribute("listvehicule", listvehicule);
		model.addAttribute("vehicule", new Vehicule());
		List<Prestation> listprestation = prService.getAllPrestation();
		model.addAttribute("listprestation", listprestation);
		model.addAttribute("prestation", new Prestation());
		
		return "accueilAgence";
	}

	
	@RequestMapping(value = "/rechercheVoyagep", method = RequestMethod.POST)
	public String rechercheVoyagep(@ModelAttribute("voyage") Voyage voIn, RedirectAttributes ra) {
		Voyage voOut = voService.getVoyage(voIn.getId());
		ra.addAttribute("id", voOut.getId());
	 return "redirect:/bovoyage/agence/recherche/{id}";
	}
	
	@RequestMapping(value = "/rechercheDestinationp", method = RequestMethod.POST)
	public String rechercheDestinationp(@ModelAttribute("destination") Voyage voIn, RedirectAttributes ra) {
		Destination voOut = deService.getDestination(voIn.getId());
		ra.addAttribute("id", voOut.getId());
	 return "redirect:/destination/agence/recherche/{id}";
	}
	
	@RequestMapping(value = "/rechercheHotelp", method = RequestMethod.POST)
	public String rechercheHotelp(@ModelAttribute("hotel") Voyage voIn, RedirectAttributes ra) {
		Hotel voOut = hoService.getHotel(voIn.getId());
		ra.addAttribute("id", voOut.getId());
	 return "redirect:/hotel/agence/recherche/{id}";
	}
	@RequestMapping(value = "/recherchePrestationp", method = RequestMethod.POST)
	public String recherchePrestationp(@ModelAttribute("prestation") Voyage voIn, RedirectAttributes ra) {
		Prestation voOut =  prService.getPrestation(voIn.getId());
		ra.addAttribute("id", voOut.getId());
	 return "redirect:/prestation/agence/recherche/{id}";
	}
	@RequestMapping(value = "/rechercheVehiculep", method = RequestMethod.POST)
	public String rechercheVehiculep(@ModelAttribute("vehicule") Voyage voIn, RedirectAttributes ra) {
		Vehicule voOut = veService.getVehicule(voIn.getId());
		ra.addAttribute("id", voOut.getId());
	 return "redirect:/vehicule/agence/recherche/{id}";
	}
	
	@RequestMapping(value = "/activeAdmin/{id}", method = RequestMethod.GET)
	public String activeClient(@PathVariable int id, HttpSession maSession) {
		Agence vOut = agService.getAgence(id);
		vOut.setActive(true);
		agService.updateAgence(vOut);
		maSession.setAttribute("agence", vOut);
		return "redirect:/BoVoyage/agence/login";
	}
	
}
