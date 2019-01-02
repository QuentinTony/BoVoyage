package fr.adaming.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.adaming.model.Client;



@Controller
public class LoginClientController {
	
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficheLogin(Model model) {
		Client clIn =  new Client();
		model.addAttribute("client", clIn);
		return "loginclient";
	}
	
	@RequestMapping(value="/loginfailure", method=RequestMethod.GET)
	public String afficheLoginEchec(Model model) {
		model.addAttribute("erreur", "true");
		
		return "loginclient";
	}
	
	@RequestMapping(value="/logoutclient", method=RequestMethod.GET)
	public String afficheLogout(Model model) {
model.addAttribute("dec", "true");
		
		return "loginclient";
	}
	
	@RequestMapping(value="/deniedclient", method=RequestMethod.GET)
	public String afficheDenied() {

		
		return "deniedclient";
	}
		
	}
	
	
	
	

