package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Formule;
import fr.adaming.service.IClientService;


@Controller
public class LoginClientController {
	
	@Autowired
	private IClientService clService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficheLogin(Model model) {
		Client clIn =  new Client();
		model.addAttribute("client", clIn);
		return "loginclient";
	}
	
	@RequestMapping(value = "/loginp", method = RequestMethod.POST)
	public String selectandsetVoyage(@ModelAttribute("client") Client cl, RedirectAttributes ra) {
	
		Client clOut = clService.isExist(cl);
		
		if (clOut!=null) {

			return "redirect:bovoyage/listvoyage";
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:login";
		}
		
	}
	
	
	
	
}
