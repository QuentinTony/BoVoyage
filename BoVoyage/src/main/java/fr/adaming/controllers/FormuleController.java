package fr.adaming.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Banque;
import fr.adaming.model.Client;
import fr.adaming.model.Destination;
import fr.adaming.model.Formule;
import fr.adaming.model.Hotel;
import fr.adaming.model.MailConfirmation;
import fr.adaming.model.Passager;
import fr.adaming.model.PdfFactureVoyage;
import fr.adaming.model.Prestation;
import fr.adaming.model.Vehicule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IBanqueService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IPassagerService;
import fr.adaming.service.IPrestationService;
import fr.adaming.service.IVehiculeService;
import fr.adaming.service.IVoyageService;
import fr.adaming.service.VoyageServiceImpl;

@SessionAttributes("client")
@Controller
@RequestMapping("/formule")
public class FormuleController {

	public static final String dest = "C:\\Users\\inti0490\\Desktop\\Formation\\Workspace\\GenerationPDF\\essaye1";

	@Autowired
	private IVoyageService voService;
	@Autowired
	private IFormuleService foService;
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
	@Autowired
	private IPrestationService prService;

	@Autowired
	private IBanqueService baService;

	public void setBaService(IBanqueService baService) {
		this.baService = baService;
	}

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

	public void setPrService(IPrestationService prService) {
		this.prService = prService;
	}

	public void setFoService(IFormuleService foService) {
		this.foService = foService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	@RequestMapping(value = "/selectformule", method = RequestMethod.GET)
	public String selectvoyage(Model model, @RequestParam("id") long id, HttpServletRequest serreq) {

		Formule fo = new Formule();

		fo.setClient((Client) serreq.getSession(false).getAttribute("client"));

		model.addAttribute("formule", fo);

		Voyage vOut = voService.getVoyage(id);
		model.addAttribute("voyage", vOut);

		List<Hotel> listHotel = hoService.getAllByDestination(vOut.getDestination().getId());
		model.addAttribute("listehotel", listHotel);

		List<Vehicule> listVehicule = veService.getAllVehicule();
		model.addAttribute("listVehicule", listVehicule);

		List<Prestation> listPrestation = prService.getAllPrestation();
		model.addAttribute("listPrestation", listPrestation);

		return "panier";
	}

	@RequestMapping(value = "/selectformulep", method = RequestMethod.POST)
	public String selectandsetVoyage(@ModelAttribute("formule") Formule fo, RedirectAttributes ra,
			HttpServletRequest serreq) {

		Formule fOut = foService.addFormule(fo);
		ra.addAttribute("id", fOut.getId());
		Formule fIn = foService.getFormule(fOut.getId());
		Date da = fIn.getVoyage().getDateDepart();
		Date dr = fIn.getVoyage().getDateRetour();
		final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
		int delta = (int) ((dr.getTime() - da.getTime()) / MILLISECONDS_PER_DAY);
		fIn.setNombreJour(delta);
		fIn.setClient((Client) serreq.getSession(false).getAttribute("client"));
		fIn.setNombreNuit(delta - 1);
		foService.updateFormule(fIn);
		Formule fIn2 = foService.getFormule(fIn.getId());
		serreq.getSession(false).setAttribute("formule", fIn2);
		System.out.println(fIn2);

		if (fOut.getId() != 0) {

			return "redirect:enregistrerpassager";
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:selectformule?id=" + fOut.getVoyage().getId();
		}

	}

	@RequestMapping(value = "/enregistrerpassager", method = RequestMethod.GET)
	public String getAdd(Model modele) {

		modele.addAttribute("passager", new Passager());

		return "addpassager";
	}

	@RequestMapping(value = "/enregistrerpassagerp", method = RequestMethod.POST)
	public String enregistrerpassagerp(RedirectAttributes ra, @Valid @ModelAttribute("passager") Passager pa,
			BindingResult br, HttpServletRequest serreq) {

		if (br.hasErrors()) {

			return "addpassager";
		}

		Passager paa = paService.addPassager(pa);

		if (paa.getId() != 0) {

			Client cl = (Client) serreq.getSession(false).getAttribute("client");
			paa.setClient(cl);
			paService.updatePassager(paa);

			Formule foIn = (Formule) serreq.getSession(false).getAttribute("formule");
			System.out.println(foIn);
			foIn = foService.getFormule(foIn.getId());
			Voyage vo = foIn.getVoyage();
			vo.setStockPassager(vo.getStockPassager() - 1);
			voService.updateVoyage(vo);

			int compteur = foIn.getCompteur();
			compteur = compteur + 1;
			foIn.setCompteur(compteur);
			foService.updateFormule(foIn);

			if (compteur < foIn.getNombrePersonne()) {
				System.out.println(compteur);

				return "redirect:enregistrerpassager";
			}

			return "redirect:validformule/" + foIn.getId();

		} else {
			ra.addAttribute("msg", "L'enregistrement a échoué");
			return "redirect:enregistrerpassager";
		}

	}

	@RequestMapping(value = "/validformule/{id}", method = RequestMethod.GET)
	public String validvoyage(Model model, @PathVariable("id") long id) {

		Formule fIn = foService.getFormule(id);
		model.addAttribute("compte", new Banque());
		model.addAttribute("formule", fIn);

		return "recapitulatifPanier";
	}

	@RequestMapping(value = "/validformule/validformulep", method = RequestMethod.POST)
	public String validvoyagepost(@ModelAttribute("formule") Formule fo, RedirectAttributes ra,
			HttpServletRequest serreq) {

		Client cl = (Client) serreq.getSession(false).getAttribute("client");
		try {
		Voyage vo=voService.getVoyage(fo.getVoyage().getId());
		 Destination de=deService.getDestination(vo.getDestination().getId());
		 Hotel ho= hoService.getHotel(fo.getHotel().getId());
		 Vehicule ve= veService.getVehicule(fo.getVehicule().getId());
		 fo.setVoyage(vo);
		 fo.getVoyage().setDestination(de);
		 fo.setHotel(ho);
		 fo.setVehicule(ve);
		}catch (Exception ex) {
			
		}PdfFactureVoyage pdf = new PdfFactureVoyage();
		try {
			pdf.generarPdf(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MailConfirmation mail = new MailConfirmation();
		
		 System.out.println("client "+cl.toString());
		mail.sendMailToCl(fo, cl);
		foService.updateFormule(fo);

		return "accueil";

	}

	@RequestMapping(value = "/validformule/submitVirement", method = RequestMethod.POST)
	public String submitVirement(RedirectAttributes ra, Model model, @ModelAttribute("compte") Banque b,
			@RequestParam("dSomme") Double somme, @RequestParam("id") long id, HttpSession maSession) {
		System.out.println("je lance la méthode viremente du controleur client");
		try {
			Banque bBoVoyage = baService.virement(b, somme);
			if (bBoVoyage.getId() != 0) {
				maSession.setAttribute("indice", "block");
				maSession.setAttribute("indice1", "none");
				return "redirect:/formule/validformule/" + id;
			} else {

				ra.addAttribute("msg", "le virement a échoué");

				return "redirect:/formule/validformule/" + id;
			}

		} catch (Exception ex) {
			ra.addAttribute("msg", "le virement a échoué");

			return "redirect:/formule/validformule/" + id;

		}
	}

}
