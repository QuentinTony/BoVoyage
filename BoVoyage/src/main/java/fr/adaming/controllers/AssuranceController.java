package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Assurance;

import fr.adaming.service.IAssuranceService;

@Controller
@RequestMapping("/assurance")
public class AssuranceController {

	@Autowired
	private IAssuranceService asService;

	public void setAsService(IAssuranceService asService) {
		this.asService = asService;
	}
	
	//1********************************************LIST*********************************************************************
	
	@RequestMapping(value="/listassurance", method=RequestMethod.GET)
	public ModelAndView afficheListe() {
		//Récuperer la liste de la BD
		
		List<Assurance> listAssurance= asService.getAllAssurance();
		return new ModelAndView("listassurances","listAssurance",listAssurance);
		
	}
	
	
	
	//2****************************************ADD*******************************************************
	
		@RequestMapping(value="/addassurance", method=RequestMethod.GET)
		public String getAdd(Model modele) {
			List<Assurance> listAssurance = asService.getAllAssurance();
			modele.addAttribute("listAssurance", listAssurance);
			modele.addAttribute("assurance", new Assurance());
			return "addassurance";
		}
		
		@RequestMapping(value="/addassurancep", method=RequestMethod.POST)
		public String submitAdd(@ModelAttribute("assurance") Assurance as ,RedirectAttributes ra) {
	
	
			Assurance aOut= asService.addAssurance(as);
			
			if(aOut.getId()!=0) {
				
				
				return "redirect:listassurance";
			}else {
				ra.addAttribute("msg", "L'ajout n'est pas fait");
				return "redirect:addassurance";
			}
		}	
		
		//3*************************************************UPDATE***************************************************************
		
		@RequestMapping(value="/updateassurance", method=RequestMethod.GET)
		public String updateClient(Model model) {
			model.addAttribute("assurance", new Assurance());
			return "updateassurance";
		}
		
		@RequestMapping(value="/updateassurancep", method=RequestMethod.POST)
		public String submitUpdate(@ModelAttribute("assurance") Assurance as, RedirectAttributes ra) {
			
		int verif= asService.updateAssurance(as);
	if(verif!=0) {
				
				//rediriger ver la methode /liste
				return "redirect:listassurance";
			}else {
				ra.addAttribute("msg", "La modification n'est pas faite");
				return "redirect:updateassurance";
			}
		}
	
		
		//4*************************************************DELETE***************************************************************
		

		@RequestMapping(value="/deleteassurance", method=RequestMethod.GET)
		public String deleteassurance(Model model) {
			List<Assurance> list = asService.getAllAssurance();
			model.addAttribute("listAssurance", list);
			model.addAttribute("assurance", new Assurance());
			return "deleteassurance";
		}
		
		@RequestMapping(value="/deleteassurancep", method=RequestMethod.POST)
		public String submitdelete(@ModelAttribute("assurance") Assurance as, RedirectAttributes ra) {
		
			
		int verif= asService.deleteAssurance(as);
	if(verif!=0) {
				
				//rediriger ver la methode /liste
				return "redirect:listassurance";
			}else {
				ra.addAttribute("msg", "L'assurance n'est pas effacé");
				return "redirect:deleteassurance";
			}
		}
		
		//5*************************************************GET***************************************************************
		
		@RequestMapping(value="/getassurance", method=RequestMethod.GET)
		public String getassurance(Model model, @RequestParam(value = "id") long id) {
			Assurance aOut = asService.getAssurance(id);
			model.addAttribute("assurance",aOut);
			return "getassurance";
		}
		
		@RequestMapping(value="/getassurancep", method=RequestMethod.POST)
		public String submitgetassurance(@ModelAttribute("assurance") Assurance as, RedirectAttributes ra) {
			Assurance aOut= asService.getAssurance(as.getId());
	if(aOut.getId()!=0) {
				
				//rediriger ver la methode /liste
				return "redirect:listassurance";
			}else {
				ra.addAttribute("msg", "L'assurance n'existe pas");
				return "redirect:getassurance";
			}
		}
}
