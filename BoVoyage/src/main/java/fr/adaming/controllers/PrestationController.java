package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.model.Prestation;
import fr.adaming.model.Vehicule;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IPrestationService;


@Controller
@RequestMapping("/prestation/agence")
public class PrestationController {
	
	@Autowired
	private IPrestationService prService;
	
	@Autowired
	private IDestinationService deService;

	public void setPrService(IPrestationService prService) {
		this.prService = prService;
	}
	
	//1********************************************LIST*********************************************************************
	
		@RequestMapping(value="/listprestation", method=RequestMethod.GET)
		public ModelAndView afficheListe() {
		
			
			List<Prestation> listPrestation= prService.getAllPrestation();
			
			return new ModelAndView("listeprestation","listPrestation",listPrestation);
			
		}
		
		@RequestMapping(value = "/recherche/{id}", method = RequestMethod.GET)
		public String rechercheVehicule(Model model , @PathVariable(value = "id") long id){
			Prestation vOut = prService.getPrestation(id);
			model.addAttribute("prestation", vOut);
			return "recherchePrestation";

		}
		
		
		//2****************************************ADD*******************************************************
		
			@RequestMapping(value="/addprestation", method=RequestMethod.GET)
			public String getAdd(Model modele) {
				List<Destination> listDest = deService.getAllDestination();
				modele.addAttribute("listdest", listDest);
				modele.addAttribute("prestation", new Prestation());
				return "addprestation";
			}
			
			@RequestMapping(value="/addprestationp", method=RequestMethod.POST)
			public String submitAdd(@ModelAttribute("prestation") Prestation ve ,MultipartFile file, RedirectAttributes ra) {
				
				try {
					byte[] photo1 = file.getBytes();
					ve.setPhoto((byte[])photo1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			Prestation vOut= prService.addPrestation(ve);
			
				
				if(vOut.getId()!=0) {
					
					
					return "redirect:/agence/recherche";
				}else {
					ra.addAttribute("msg", "L'ajout n'est pas fait");
					return "redirect:addprestation";
				}
			}
			
			//3*************************************************UPDATE***************************************************************
			
			@RequestMapping(value="/updateprestation", method=RequestMethod.GET)
			public String updateDestination(Model model) {
				model.addAttribute("prestation", new Prestation());
				return "updateprestation";
			}
			
			@RequestMapping(value="/updateprestationp", method=RequestMethod.POST)
			public String submitUpdate(@ModelAttribute("prestation") Prestation ve, RedirectAttributes ra) {
				
			int verif= prService.updatePrestation(ve);
		if(verif!=0) {
					
					//rediriger ver la methode /liste
					return "redirect:listprestation";
				}else {
					ra.addAttribute("msg", "La modification n'est pas faite");
					return "redirect:updateprestation";
				}
			}
		
			
			//4*************************************************DELETE***************************************************************
			

			@RequestMapping(value="/deleteprestation", method=RequestMethod.GET)
			public String deleteDestination(Model model) {
				List<Prestation> listPrestation= prService.getAllPrestation();
				model.addAttribute("listprestation", listPrestation);
				model.addAttribute("prestation", new Prestation());
				return "deleteprestation";
			}
			
			@RequestMapping(value="/deleteprestationp", method=RequestMethod.POST)
			public String submitdelete(@ModelAttribute("prestation") Prestation ve, RedirectAttributes ra) {
				Prestation vOut= prService.getPrestation(ve.getId());
				int verif= prService.deletePrestation(vOut);
		       if(verif!=0) {
					
					//rediriger ver la methode /liste
					return "accueilAgence";
				}else {
					ra.addAttribute("msg", "La voiture  n'est pas effacé");
					return "redirect:deleteprestation";
				}
			}
			
			//5*************************************************GET***************************************************************
			
			@RequestMapping(value="/getprestation", method=RequestMethod.GET)
			public String getDestination(Model model) {
				model.addAttribute("prestation", new Prestation());
				return "getprestation";
			}
			
			@RequestMapping(value="/getprestationp", method=RequestMethod.POST)
			public String submitgetdestination(@ModelAttribute("prestation") Prestation ve, RedirectAttributes ra) {
				
			Prestation vOut= prService.getPrestation(ve.getId());
		if(vOut.getId()!=0) {
					
					//rediriger ver la methode /liste
					return "redirect:listprestation";
				}else {
					ra.addAttribute("msg", "Le prestation n'existe pas");
					return "redirect:getprestation";
				}
			}


}
