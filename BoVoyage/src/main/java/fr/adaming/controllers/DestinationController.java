package fr.adaming.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.model.Vehicule;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/destination")
public class DestinationController {
	@Autowired
	private IDestinationService dOutService;
	
	

	public void setVoService(IDestinationService dOutService) {
		this.dOutService = dOutService;
	}

	//1********************************************LIST*********************************************************************
	
	@RequestMapping(value="/listdestination", method=RequestMethod.GET)
	public ModelAndView afficheListe() {
		//Récuperer la liste de la BD
		
		List<Destination> listDestination= dOutService.getAllDestination();
		
		return new ModelAndView("accueil","listDestination",listDestination);
		
	}

	@RequestMapping(value = "/agence/recherche/{id}", method = RequestMethod.GET)
	public String rechercheVehicule(Model model , @PathVariable(value = "id") long id){
		Destination vOut = dOutService.getDestination(id);
		model.addAttribute("destination", vOut);
		return "rechercheDestination";

	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate= new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	//2****************************************ADD*******************************************************
	
		@RequestMapping(value="/agence/adddestination", method=RequestMethod.GET)
		public String getAdd(Model modele) {
			
			modele.addAttribute("destination", new Destination());
			return "adddestination";
		}
		
		@RequestMapping(value="/agence/adddestinationp", method=RequestMethod.POST)
		public String submitAdd(@ModelAttribute("destination") Destination dOut ,MultipartFile file, RedirectAttributes ra) {
			
			try {
				byte[] photo1 = file.getBytes();
				dOut.setPhoto((byte[])photo1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Destination vOut= dOutService.addDestination(dOut);
		
			
			if(vOut.getId()!=0) {
				
				
				return "redirect:/agence/recherche";
			}else {
				ra.addAttribute("msg", "L'ajout n'est pas fait");
				return "redirect:adddestination";
			}
		}
		
		//3*************************************************UPDATE***************************************************************
		
		@RequestMapping(value="/agence/updatedestination", method=RequestMethod.GET)
		public String updateDestination(Model model) {
			model.addAttribute("destination", new Destination());
			return "updatedestination";
		}
		
		@RequestMapping(value="/agence/updatedestinationp", method=RequestMethod.POST)
		public String submitUpdate(@ModelAttribute("destination") Destination dOut, RedirectAttributes ra) {
			
		int verif= dOutService.updateDestination(dOut);
	if(verif!=0) {
				
				//rediriger ver la methode /liste
				return "redirect:listdestination";
			}else {
				ra.addAttribute("msg", "La modification n'est pas faite");
				return "redirect:updatedestination";
			}
		}
	
		
		//4*************************************************DELETE***************************************************************
		

		@RequestMapping(value="/agence/deletedestination", method=RequestMethod.GET)
		public String deleteDestination(Model model) {
			List<Destination> listDestination= dOutService.getAllDestination();
			model.addAttribute("listdestination", listDestination);
			model.addAttribute("destination", new Destination());
			return "deletedestination";
		}
		
		@RequestMapping(value="/agence/deletedestinationp", method=RequestMethod.POST)
		public String submitdelete(@ModelAttribute("destination") Destination dOut, RedirectAttributes ra) {
			Destination dIn= dOutService.getDestination(dOut.getId());
		int verif= dOutService.deleteDestination(dIn);
	if(verif!=0) {
				
				//rediriger ver la methode /liste
				return "accueilAgence";
			}else {
				ra.addAttribute("msg", "Le destination n'est pas effacé");
				return "redirect:deletedestination";
			}
		}
		
		//5*************************************************GET***************************************************************
		
		@RequestMapping(value="/agence/getdestination", method=RequestMethod.GET)
		public String getDestination(Model model) {
			model.addAttribute("destination", new Destination());
			return "getdestination";
		}
		
		@RequestMapping(value="/agence/getdestinationp", method=RequestMethod.POST)
		public String submitgetdestination(@ModelAttribute("destination") Destination dOut, RedirectAttributes ra) {
			
		Destination dIn= dOutService.getDestination(dOut.getId());
	if(dIn.getId()!=0) {
				
				//rediriger ver la methode /liste
				return "redirect:listdestination";
			}else {
				ra.addAttribute("msg", "Le destination n'existe pas");
				return "redirect:getdestination";
			}
		}

}
