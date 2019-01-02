package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import fr.adaming.model.Agence;
import fr.adaming.model.Destination;
import fr.adaming.model.Agence;
import fr.adaming.service.IAgenceService;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/direction")
public class DirectionController {
	
	@Autowired
	private IAgenceService agService;
	
	public void setAgService(IAgenceService agService) {
		this.agService = agService;
	}
	
	
	// 1********************************************LIST*********************************************************************

		@RequestMapping(value = "/listagent", method = RequestMethod.GET)
		public String afficheListe(Model model) {
			//Recuperer l'identifiant de l'admin a partir du context de spring security
			Authentication auth= SecurityContextHolder.getContext().getAuthentication();
			//Recuperer l'identifiant
			
			String mail= auth.getName();
			model.addAttribute("identifiant",mail);
			model.addAttribute("msg", "Bonjour M. Client. Vous êtes dans votre PortailClient");
			// Récuperer la liste de la BD
			List<Agence> listagent = agService.getAllAgence();
			model.addAttribute("listAgence", listagent);
			Agence ag =  new Agence();
			model.addAttribute("agent", ag);
			return "accueilDirection"; 

		}
		
	

		// 2****************************************ADD*******************************************************

		@RequestMapping(value = "/agence/addagentp", method = RequestMethod.POST)
		public String submitAdd(@ModelAttribute("agent") Agence vo, RedirectAttributes ra) {

			Agence vOut = agService.addAgence(vo);

			if (vOut.getId() != 0) {

				return "redirect:/direction/listagent";
			} else {
				ra.addAttribute("msg", "L'ajout n'est pas fait");
				return "redirect:addvoyage";
			}
		}

		// 4*************************************************DELETE***************************************************************

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String submitdelete(@ModelAttribute("agence") Agence vo,@PathVariable("id") long idA, RedirectAttributes ra) {
			System.out.println(idA);
			Agence ag = agService.getAgence(idA);
			System.out.println(ag);
			int verif = agService.deleteAgence(ag);
			System.out.println(verif);
			if (verif != 0) {
				// rediriger ver la methode /liste
				return "redirect:/direction/listagent";
			} else {
				ra.addAttribute("msg", "Le voyage n'est pas effacé");
				return "redirect:listagent";
			}
		}

		// 5*************************************************GET***************************************************************

		@RequestMapping(value = "/recherche/{id}", method = RequestMethod.GET)
		public String getAgence(Model model, @PathVariable(value = "id") long id, RedirectAttributes ra) {
			Agence vOut = agService.getAgence(id);
			model.addAttribute("agent", vOut);
			ra.addAttribute("id", vOut.getId());
			return "rechercheAgent";
		}

		@RequestMapping(value = "/recherchep", method = RequestMethod.POST)
		public String submitgetvoyage(@ModelAttribute("agent") Agence vo, RedirectAttributes ra) {
			int verif = agService.updateAgence(vo);
			if (verif != 0) {

				// rediriger ver la methode /liste
				return "redirect:/direction/listagent";
			} else {
				ra.addAttribute("msg", "Le voyage n'existe pas");
				return "redirect:getvoyage";
			}
		}

}
