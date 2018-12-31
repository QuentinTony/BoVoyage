package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Banque;
import fr.adaming.service.IBanqueService;

@Controller
@RequestMapping("/wsbanque")
public class BanqueController {

	// transformation de l'association UML en JAVA
	@Autowired
	private IBanqueService baService;
	
	public void setBaService(IBanqueService baService) {
		this.baService = baService;
	}

	// Detection des Dates
	@InitBinder // dans chaque controller
	public void initBinder(WebDataBinder binder) {

		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	
	// methode get information du compte
	@RequestMapping(value="/getVirement", method=RequestMethod.GET)
	public String getVirement(Model modele) {
		
		modele.addAttribute("compte", new Banque());
		return "WSBanque";
	}
	
	
	@RequestMapping(value="/submitVirement", method=RequestMethod.POST)
	public String submitVirement(RedirectAttributes ra,@ModelAttribute ("compte") Banque b,@RequestParam("dSomme") Double somme) {
		
		Banque bBoVoyage=baService.virement(b, somme);
		if (bBoVoyage.getId()!=0) {
			return "panier";
		}else {
			ra.addAttribute("msg","le virement a échoué");
			return "redirect:getVirement";
		}
		
		
	}
	

}
