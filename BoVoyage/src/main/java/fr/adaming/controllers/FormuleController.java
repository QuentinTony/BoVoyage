package fr.adaming.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Formule;
import fr.adaming.model.Hotel;
import fr.adaming.model.Prestation;
import fr.adaming.model.Vehicule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IPassagerService;
import fr.adaming.service.IPrestationService;
import fr.adaming.service.IVehiculeService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/formule")
public class FormuleController {
	
	
	@Autowired
	private IVoyageService voService;
	@Autowired
	private IFormuleService foService;
	@Autowired
	private IDestinationService deService;
	@Autowired
	private IHotelService hoService;
	@Autowired
	private IAssuranceService asService;
	@Autowired
	private IVehiculeService veService;
	@Autowired
	private IPassagerService paService;
	@Autowired
	private IClientService clService;
	@Autowired
	private IPrestationService prService;
	
	

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

	public void setPaService(IPassagerService paService) {
		this.paService = paService;
	}

	public void setVoService(IVoyageService voService) {
		this.voService = voService;
	}
	
	public void setPrService(IPrestationService prService) {
		this.prService = prService;
	}
	
	public void setFoService(IFormuleService foService) {
		this.foService = foService;
	}
	@RequestMapping(value = "/selectformule", method = RequestMethod.GET)
	public String selectvoyage(Model model,  @RequestParam(value = "id") long id) {
		Formule fo=new Formule();
		model.addAttribute("formule",fo);
		
		Voyage vOut = voService.getVoyage(id);
		model.addAttribute("voyage", vOut);
		
		List<Hotel> listHotel = hoService.getAllByDestination(vOut.getDestination().getId());
		model.addAttribute("listehotel", listHotel);
		
		List<Vehicule> listVehicule = veService.getAllVehicule();
		model.addAttribute("listVehicule", listVehicule);
		
		List<Prestation> listPrestation = prService.getAllPrestation();
		model.addAttribute("listPrestation", listPrestation);
		
		return "panier";
	}

	
	@RequestMapping(value = "/selectformulep", method = RequestMethod.POST)
	public String selectandsetVoyage(@ModelAttribute("formule") Formule fo, RedirectAttributes ra) {
	
		Formule fOut = foService.addFormule(fo);
		ra.addAttribute("id", fOut.getId());
		

		if (fOut.getId() != 0) {

			return "redirect:validformule/{id}";
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:selectformule";
		}
		
	}
	
	
	@RequestMapping(value = "/validformule/{id}", method = RequestMethod.GET)
	public String validvoyage(Model model,  @PathVariable("id") long id) {
		Formule fIn = foService.getFormule(id);
		model.addAttribute("formule",fIn);
		
				
		return "recapitulatifPanier";
	}

	
	@RequestMapping(value = "/validformule/validformulep", method = RequestMethod.POST)
	public String validvoyagepost(@ModelAttribute("formule") Formule fo, RedirectAttributes ra) {
	
		foService.updateFormule(fo);
		

		
			return "accueil";
		
		}
		
	}


