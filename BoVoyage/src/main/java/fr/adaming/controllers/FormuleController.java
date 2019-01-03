package fr.adaming.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import fr.adaming.service.IClientService;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IPassagerService;
import fr.adaming.service.IPrestationService;
import fr.adaming.service.IVehiculeService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/formule")
public class FormuleController {

	public static final String dest= "C:\\Users\\inti0490\\Desktop\\Formation\\Workspace\\GenerationPDF\\essaye1";
	
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

	@RequestMapping(value = "/selectformule", method = RequestMethod.GET)
	public String selectvoyage(Model model, @RequestParam("id") long id) {
		Formule fo = new Formule();
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
	public String selectandsetVoyage(@ModelAttribute("formule") Formule fo, RedirectAttributes ra) {

		Formule fOut = foService.addFormule(fo);
		ra.addAttribute("id", fOut.getId());
		Formule fIn = foService.getFormule(fOut.getId());
		Date da = fIn.getVoyage().getDateDepart();
		Date dr = fIn.getVoyage().getDateRetour();
		final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
		int delta = (int) ((dr.getTime() - da.getTime()) / MILLISECONDS_PER_DAY);
		fIn.setNombreJour(delta);
		fIn.setNombreNuit(delta - 1);
		foService.updateFormule(fIn);
		if (fOut.getId() != 0) {

			return "redirect:enregistrerpassager/"+fOut.getId();
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:selectformule/"+fOut.getId();
		}

	}

	@RequestMapping(value = "/validformule/{id}", method = RequestMethod.GET)
	public String validvoyage(Model model, @PathVariable("id") long id) {
		
		Formule fIn = foService.getFormule(id);
		
		model.addAttribute("formule", fIn);

		return "recapitulatifPanier";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
	
	
	@RequestMapping(value = "/enregistrerpassager/{id}", method = RequestMethod.GET)
	public String getAdd(Model modele, @PathVariable("id") long id) {
		
		Formule fIn = foService.getFormule(id);
		
		modele.addAttribute("formule", fIn);

		modele.addAttribute("passager", new Passager());
		
		return "addpassager";
	}
	
	
	@RequestMapping(value = "/enregistrerpassagerp", method = RequestMethod.POST)
	public String enregistrerpassagerp(RedirectAttributes ra, @ModelAttribute("formule") Formule fo, @Valid @ModelAttribute("passager") Passager pa, BindingResult br) {
		
		if (br.hasErrors()) {

			return "addpassager";
		}
		
		Passager paa = paService.addPassager(pa);
		
		if (paa.getId() != 0) {
			
				Client cl = fo.getClient();
	
				paa.setClient(cl);
				
				int a = fo.getNombrePersonne() - 1 ;
				
				if (a > 0) {
					
					return "redirect:enregistrerpassager/"+fo.getId();
					
				} else {
					
					return "redirect:validformule/"+fo.getId();
				}
				
		} else {
			ra.addAttribute("msg", "L'enregistrement a échoué");
			return "redirect:enregistrerpassager/"+fo.getId();
		}
		
	}

	
	@RequestMapping(value = "/validformule/validformulep", method = RequestMethod.POST)
	public String validvoyagepost(@ModelAttribute("formule") Formule fo, RedirectAttributes ra) {
		
		MailConfirmation mail= new MailConfirmation();
		PdfFactureVoyage pdf= new PdfFactureVoyage();
		try {
			pdf.generarPdf(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client cl= fo.getClient();
		mail.sendMailToCl(fo, cl);
		foService.updateFormule(fo);

		return "accueil";

	}
	
	
//	@RequestMapping(value = "/validformule/{id}", method = RequestMethod.GET)
//	public String validvoyage(Model model, @PathVariable("id") long id) {
//		Formule fIn = foService.getFormule(id);
//		
//
//		model.addAttribute("formule", fIn);
//
//		return "recapitulatifPanier";
//	}
//
//	@RequestMapping(value = "/validformule/validformulep", method = RequestMethod.POST)
//	public String validvoyagepost(@ModelAttribute("formule") Formule fo, RedirectAttributes ra) {
//
//		foService.updateFormule(fo);
//
//		return "accueil";
//
//	}

}
