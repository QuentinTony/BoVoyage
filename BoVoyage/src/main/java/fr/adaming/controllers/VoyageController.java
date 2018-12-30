package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Assurance;
import fr.adaming.model.Destination;
import fr.adaming.model.Hotel;
import fr.adaming.model.Passager;
import fr.adaming.model.Vehicule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IPassagerService;
import fr.adaming.service.IVehiculeService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/bovoyage")
public class VoyageController {

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
	private IPassagerService paService;
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

	public void setPaService(IPassagerService paService) {
		this.paService = paService;
	}

	public void setVoService(IVoyageService voService) {
		this.voService = voService;
	}

	// 1********************************************LIST*********************************************************************

	@RequestMapping(value = "/listvoyage", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// Récuperer la liste de la BD

		List<Voyage> listvoyage = voService.getAllVoyage();
		return new ModelAndView("accueil", "listVoyage", listvoyage);

	}
	
	@RequestMapping(value = "/agence/recherche/{id}", method = RequestMethod.GET)
	public String rechercheVoyage(Model model , @PathVariable(value = "id") long id){
		Voyage vOut = voService.getVoyage(id);
		model.addAttribute("voyage", vOut);
		return "rechercheVoyage";

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	// 2****************************************ADD*******************************************************

	@RequestMapping(value = "/agence/addvoyage", method = RequestMethod.GET)
	public String getAdd(Model modele) {
		List<Destination> listDestination = deService.getAllDestination();
		modele.addAttribute("listdestination", listDestination);
		modele.addAttribute("voyage", new Voyage());
		return "addvoyage";
	}

	@RequestMapping(value = "/agence/addvoyagep", method = RequestMethod.POST)
	public String submitAdd(@ModelAttribute("voyage") Voyage vo, RedirectAttributes ra) {

		Voyage vOut = voService.addVoyage(vo);

		if (vOut.getId() != 0) {

			return "redirect:listvoyage";
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:addvoyage";
		}
	}

	// 3*************************************************UPDATE***************************************************************

	@RequestMapping(value = "/updatevoyage", method = RequestMethod.GET)
	public String updateVoyage(Model model) {
		model.addAttribute("voyage", new Voyage());
		return "updatevoyage";
	}

	@RequestMapping(value = "/updatevoyagep", method = RequestMethod.POST)
	public String submitUpdate(@ModelAttribute("voyage") Voyage vo, RedirectAttributes ra) {

		int verif = voService.updateVoyage(vo);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:listvoyage";
		} else {
			ra.addAttribute("msg", "La modification n'est pas faite");
			return "redirect:updatevoyage";
		}
	}

	// 4*************************************************DELETE***************************************************************

	@RequestMapping(value = "/agence/deletevoyage", method = RequestMethod.GET)
	public String deleteVoyage(Model model) {
		List<Voyage> list = voService.getAllVoyage();
		model.addAttribute("listVoyage", list);
		model.addAttribute("voyage", new Voyage());
		return "deletevoyage";
	}

	@RequestMapping(value = "/agence/deletevoyagep", method = RequestMethod.POST)
	public String submitdelete(@ModelAttribute("voyage") Voyage vo, RedirectAttributes ra) {

		int verif = voService.deleteVoyage(vo);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:listvoyage";
		} else {
			ra.addAttribute("msg", "Le voyage n'est pas effacé");
			return "redirect:deletevoyage";
		}
	}

	// 5*************************************************GET***************************************************************

	@RequestMapping(value = "/getvoyage", method = RequestMethod.GET)
	public String getVoyage(Model model, @RequestParam(value = "id") long id) {
		Voyage vOut = voService.getVoyage(id);
		model.addAttribute("voyage", vOut);
		return "getvoyage";
	}

	@RequestMapping(value = "/getvoyagep", method = RequestMethod.POST)
	public String submitgetvoyage(@ModelAttribute("voyage") Voyage vo, RedirectAttributes ra) {
		Voyage vOut = voService.getVoyage(vo.getId());
		if (vOut.getId() != 0) {

			// rediriger ver la methode /liste
			return "redirect:listvoyage";
		} else {
			ra.addAttribute("msg", "Le voyage n'existe pas");
			return "redirect:getvoyage";
		}
	}


}
