package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Agence;

@Controller
public class LoginController {



	@RequestMapping(value="/login2", method=RequestMethod.GET)
	public String afficheLogin2(Model model) {
		Agence agIn =  new Agence();
		model.addAttribute("agence", agIn);
		return "conectarse";
	}
	
	@RequestMapping(value="/loginechec", method=RequestMethod.GET)
	public String afficheLoginEchec(Model model) {
		model.addAttribute("erreur", "true");
		
		return "loginagence";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String afficheLogout(Model model) {
model.addAttribute("dec", "true");
		
		return "loginagence";
	}
	
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String afficheDenied() {

		
		return "denied";
	}
}
