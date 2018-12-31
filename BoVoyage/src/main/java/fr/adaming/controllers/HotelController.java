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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.model.Hotel;
import fr.adaming.model.Vehicule;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/hotel/agence")
public class HotelController {

	@Autowired
	private IHotelService hoService;
	@Autowired
	private IDestinationService deService;

	public void setHoService(IHotelService hoService) {
		this.hoService = hoService;
	}

	// 1********************************************LIST*********************************************************************

	@RequestMapping(value = "/listhotel", method = RequestMethod.GET)
	public ModelAndView afficheListe() {

		List<Hotel> listHotel = hoService.getAllHotel();
		return new ModelAndView("accueilAgence", "listhotel", listHotel);

	}

	@RequestMapping(value = "/recherche/{id}", method = RequestMethod.GET)
	public String rechercheVehicule(Model model, @PathVariable(value = "id") long id) {
		Hotel vOut = hoService.getHotel(id);
		model.addAttribute("hotel", vOut);
		return "rechercheHotel";

	}

	// 2****************************************ADD*******************************************************

	@RequestMapping(value = "/addhotel", method = RequestMethod.GET)
	public String getAdd(Model modele) {
		List<Destination> listDest = deService.getAllDestination();
		modele.addAttribute("listdest", listDest);
		modele.addAttribute("hotel", new Hotel());
		return "addhotel";
	}

	@RequestMapping(value = "/addhotelp", method = RequestMethod.POST)
	public String submitAdd(@ModelAttribute("hotel") Hotel ho, MultipartFile file, RedirectAttributes ra) {

		try {
			byte[] photo1 = file.getBytes();

			ho.setPhoto((byte[]) photo1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Hotel hOut = hoService.addHotel(ho);

		if (hOut.getId() != 0) {

			return "redirect:/agence/recherche";
		} else {
			ra.addAttribute("msg", "L'ajout n'est pas fait");
			return "redirect:addhotel";
		}
	}

	@RequestMapping(value = "/photoD/{idD}", method = RequestMethod.GET)
	public @ResponseBody void imageDestination(@PathVariable("idD") int id, HttpServletResponse response) {

		byte[] image = (hoService.getHotel(id)).getPhoto();

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

	@RequestMapping(value = "/updatehotel", method = RequestMethod.GET)
	public String updateHotel(Model model) {
		List<Destination> listDest = deService.getAllDestination();
		model.addAttribute("listdest", listDest);
		model.addAttribute("hotel", new Hotel());
		return "updatehotel";
	}

	@RequestMapping(value = "/updatehotelp", method = RequestMethod.POST)
	public String submitUpdate(@ModelAttribute("hotel") Hotel ho, RedirectAttributes ra, MultipartFile file) {
		try {
			byte[] photo1 = file.getBytes();

			if (photo1.length != 0) {
				ho.setPhoto((byte[]) photo1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int verif = hoService.updateHotel(ho);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:listhotel";
		} else {
			ra.addAttribute("msg", "La modification n'est pas faite");
			return "redirect:updatehotel";
		}
	}

	// 4*************************************************DELETE***************************************************************

	@RequestMapping(value = "/deletehotel", method = RequestMethod.GET)
	public String deleteHotel(Model model) {
		List<Hotel> listHotel = hoService.getAllHotel();
		model.addAttribute("listhotel", listHotel);
		model.addAttribute("hotel", new Hotel());
		return "deletehotel";
	}

	@RequestMapping(value = "/deletehotelp", method = RequestMethod.POST)
	public String submitdelete(@ModelAttribute("hotel") Hotel ho, RedirectAttributes ra) {

		Hotel hOut = hoService.getHotel(ho.getId());
		int verif = hoService.deleteHotel(hOut);
		if (verif != 0) {

			// rediriger ver la methode /liste
			return "redirect:listhotel";
		} else {
			ra.addAttribute("msg", "L'hôtel n'est pas effacé");
			return "redirect:deletehotel";
		}
	}

	// 5*************************************************GET***************************************************************

	@RequestMapping(value = "/gethotel", method = RequestMethod.GET)
	public String getHotel(Model model, @RequestParam(value = "id") long id) {
		Hotel hOut = hoService.getHotel(id);
		model.addAttribute("hotel", hOut);
		return "gethotel";
	}

	@RequestMapping(value = "/gethotelp", method = RequestMethod.POST)
	public String submitgethotel(@ModelAttribute("hotel") Hotel ho, RedirectAttributes ra) {
		Hotel hOut = hoService.getHotel(ho.getId());

		if (hOut.getId() != 0) {

			// rediriger ver la methode /liste
			return "redirect:listhotel";
		} else {
			ra.addAttribute("msg", "L'hôtel  n'existe pas");
			return "redirect:gethotel";
		}
	}
}
