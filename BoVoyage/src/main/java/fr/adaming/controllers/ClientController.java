package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.MailActivation;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clService;
	
	
	public ClientController() {
		super();
	}

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficheLogin(Model model) {
		Client clIn =  new Client();
		model.addAttribute("client", clIn);
		
		return "loginclient";
	}
	
	@RequestMapping(value="/loginp", method=RequestMethod.POST)
	public String submitLogin(Model model, @ModelAttribute(value="client") Client cl, HttpSession maSession) {
		try {
		Client clOut=clService.isExist(cl);
		maSession.setAttribute("client", clOut);
		return "redirect:/bovoyage/listvoyage";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	

	// 1********************************************LIST*********************************************************************

	@RequestMapping(value = "/listclient", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// R�cuperer la liste de la BD

		List<Client> listClient = clService.getAllClient();
		return new ModelAndView("accueilAgence", "listclient", listClient);

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	// 2****************************************ADD*******************************************************

	@RequestMapping(value = "/addclient", method = RequestMethod.GET)
	public String getAdd(Model modele) {
		List<Client> listClient = clService.getAllClient();
		modele.addAttribute("listclient", listClient);
		modele.addAttribute("client", new Client());
		return "addclient";
	}

	@RequestMapping(value = "/addclientp", method = RequestMethod.POST)
	public String submitAdd(RedirectAttributes ra, @Valid @ModelAttribute("client") Client cl, BindingResult br) {

		if (br.hasErrors()) {

			return "addclient";
		}
		Client cOut = clService.addClient(cl);

		if (cOut.getId() != 0) {
			MailActivation mail = new MailActivation();
			
			mail.sendMailToCl(cOut);
			return "loginclient";
		} else {
			ra.addAttribute("msg", "L'ajout a �chou�");
			return "redirect:addclient";
		}

	}

	// 3*************************************************UPDATE***************************************************************

	@RequestMapping(value = "/updateclient", method = RequestMethod.GET)
	public String updateClient(Model model) {
		model.addAttribute("client", new Client());
		return "updateclient";
	}

	@RequestMapping(value = "/updateclientp", method = RequestMethod.POST)
	public String submitUpdate(RedirectAttributes ra, @Valid @ModelAttribute("client") Client cl, BindingResult br) {
		if (br.hasErrors()) {

			return "updateclient";
		}
		int verif = clService.updateClient(cl);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:listclient";
		} else {
			ra.addAttribute("msg", "La modification n'est pas faite");
			return "redirect:updateclient";
		}
	}

	// 4*************************************************DELETE***************************************************************

	@RequestMapping(value = "/deleteclient", method = RequestMethod.GET)
	public String deleteClient(Model model) {
		List<Client> list = clService.getAllClient();
		model.addAttribute("listClient", list);
		model.addAttribute("client", new Client());
		return "deleteclient";
	}

	@RequestMapping(value = "/deleteclientp", method = RequestMethod.POST)
	public String submitdelete(@ModelAttribute("client") Client cl, RedirectAttributes ra) {

		int verif = clService.deleteClient(cl);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:listclient";
		} else {
			ra.addAttribute("msg", "Le client n'est pas effac�");
			return "redirect:deleteclient";
		}
	}

	// 5*************************************************GET***************************************************************

	@RequestMapping(value = "/getclient", method = RequestMethod.GET)
	public String getClient(Model model, @RequestParam(value = "id") long id) {
		Client cOut = clService.getClient(id);
		model.addAttribute("client", cOut);
		return "getclient";
	}

	@RequestMapping(value = "/getclientp", method = RequestMethod.POST)
	public String submitgetvoyage(@ModelAttribute("client") Client cl, RedirectAttributes ra) {
		Client cOut = clService.getClient(cl.getId());
		if (cOut.getId() != 0) {

			// rediriger ver la methode /liste
			return "redirect:listclient";
		} else {
			ra.addAttribute("msg", "Le client n'existe pas");
			return "redirect:getclient";
		}
	}
	
	@RequestMapping(value = "/activeClient/{id}", method = RequestMethod.GET)
	public String activeClient(@PathVariable int id, HttpSession maSession) {
		Client clOut = clService.getClient(id);
		clOut.setActive(true);
		clService.updateClient(clOut);
		maSession.setAttribute("client", clOut);
		return "/BoVoyage/bovoyage/listvoyage";
	}

}
