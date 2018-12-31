package fr.adaming.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.model.Vehicule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IVehiculeService;

@Controller
@RequestMapping("/vehicule/agence")
public class VehiculeController {

	@Autowired
	private IVehiculeService veService;

	@Autowired
	private IDestinationService deService;

	public void setVeService(IVehiculeService veService) {
		this.veService = veService;
	}

	// 1********************************************LIST*********************************************************************

	@RequestMapping(value = "/listvehicule", method = RequestMethod.GET)
	public ModelAndView afficheListe() {

		List<Vehicule> listVehicule = veService.getAllVehicule();

		return new ModelAndView("listevoitures", "listVehicule", listVehicule);

	}

	@RequestMapping(value = "/recherche/{id}", method = RequestMethod.GET)
	public String rechercheVehicule(Model model, @PathVariable(value = "id") long id) {
		Vehicule vOut = veService.getVehicule(id);
		model.addAttribute("vehicule", vOut);
		return "rechercheVehicule";

	}

	// 2****************************************ADD*******************************************************

	@RequestMapping(value = "/addvehicule", method = RequestMethod.GET)
	public String getAdd(Model modele) {
		List<Destination> listDest = deService.getAllDestination();
		modele.addAttribute("listdest", listDest);
		modele.addAttribute("vehicule", new Vehicule());
		return "addvehicule";
	}

	@RequestMapping(value = "/addvehiculep", method = RequestMethod.POST)
	public String submitAdd(@ModelAttribute("vehicule") Vehicule ve, MultipartFile file, RedirectAttributes ra) {

		try {
			byte[] photo1 = file.getBytes();
			ve.setPhoto((byte[]) photo1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Vehicule vOut = veService.addVehicule(ve);

		if (vOut.getId() != 0) {

			return "redirect:/agence/recherche";
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:addvehicule";
		}
	}

	@RequestMapping(value = "/photoD/{idD}", method = RequestMethod.GET)
	public @ResponseBody void imageDestination(@PathVariable("idD") int id, HttpServletResponse response) {

		byte[] image = (veService.getVehicule(id)).getPhoto();

		ServletOutputStream outputStream;
		try {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			outputStream = response.getOutputStream();
			outputStream.write(image);
			outputStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	// 3*************************************************UPDATE***************************************************************

	@RequestMapping(value = "/updatevehicule", method = RequestMethod.GET)
	public String updateDestination(Model model) {
		List<Destination> listDest = deService.getAllDestination();
		model.addAttribute("listdest", listDest);
		model.addAttribute("vehicule", new Vehicule());
		return "updatevehicule";
	}

	@RequestMapping(value = "/updatevehiculep", method = RequestMethod.POST)
	public String submitUpdate(@ModelAttribute("vehicule") Vehicule ve, RedirectAttributes ra, MultipartFile file) {
		try {
			byte[] photo1 = file.getBytes();
			if(photo1.length!=0) {
				ve.setPhoto((byte[]) photo1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int verif = veService.updateVehicule(ve);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:/agence/recherche";
		} else {
			ra.addAttribute("msg", "La modification n'est pas faite");
			return "redirect:updatevehicule";
		}
	}

	// 4*************************************************DELETE***************************************************************

	@RequestMapping(value = "/deletevehicule", method = RequestMethod.GET)
	public String deleteDestination(Model model) {
		List<Vehicule> listVehicule = veService.getAllVehicule();
		model.addAttribute("listevoitures", listVehicule);
		model.addAttribute("vehicule", new Vehicule());
		return "deletevehicule";
	}

	@RequestMapping(value = "/deletevehiculep", method = RequestMethod.POST)
	public String submitdelete(@ModelAttribute("vehicule") Vehicule ve, RedirectAttributes ra) {
		Vehicule vOut = veService.getVehicule(ve.getId());
		int verif = veService.deleteVehicule(vOut);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "accueilAgence";
		} else {
			ra.addAttribute("msg", "La voiture  n'est pas effacé");
			return "redirect:deletevehicule";
		}
	}

	// 5*************************************************GET***************************************************************

	@RequestMapping(value = "/getvehicule", method = RequestMethod.GET)
	public String getDestination(Model model) {
		model.addAttribute("vehicule", new Vehicule());
		return "getvehicule";
	}

	@RequestMapping(value = "/getvehiculep", method = RequestMethod.POST)
	public String submitgetdestination(@ModelAttribute("vehicule") Vehicule ve, RedirectAttributes ra) {

		Vehicule vOut = veService.getVehicule(ve.getId());
		if (vOut.getId() != 0) {

			// rediriger ver la methode /liste
			return "redirect:listvehicule";
		} else {
			ra.addAttribute("msg", "Le vehicule n'existe pas");
			return "redirect:getvehicule";
		}
	}

}
