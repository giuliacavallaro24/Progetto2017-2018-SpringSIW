package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.controller.validator.AttivitaValidator;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;

@Controller
public class AttivitaController {

	@Autowired
	private AttivitaService attivitaService;

	@Autowired
	private CentroService centroService;

	@Autowired
	private AttivitaValidator validator;

	@RequestMapping("/activities")
	public String activities(Model model) {
		model.addAttribute("activities", this.attivitaService.findAll());
		return "attivitaTable"; // return "allievoList";
	}

	@RequestMapping("/centro/{idc}/activities")
	public String activitiesCentro(@PathVariable("idc") Long idc, Model model) {
		Centro centro = centroService.findById(idc);
		model.addAttribute("centro",centro);
		model.addAttribute("activities", centro.getAttivita());
		return "attivitaTable";
	}

	@RequestMapping("/centro/{idc}/addAttivita")
	public String addAttivita(Model model, @PathVariable("idc") Long idc) {
		Centro centro = centroService.findById(idc);
		model.addAttribute("centro",centro);
		model.addAttribute("attivita", new Attivita());
		return "attivitaForm";
	}

	@RequestMapping(value = "/centro/{idc}/attivita/{ida}", method = RequestMethod.GET)
	public String getAttivita(@PathVariable("idc") Long idc, Model model, @PathVariable("ida") Long ida) {
		Centro centro = centroService.findById(idc);
		model.addAttribute("centro",centro);
		model.addAttribute("attivita", this.attivitaService.findById(ida));
		return "showAttivita";
	}

	@RequestMapping("/centro/{idc}/attivita")
	public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, Model model,
			BindingResult bindingResult, @PathVariable("idc") Long idc) {
		this.validator.validate(attivita, bindingResult);

		if (this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("exists", "Attivita gia' esistente");
			return "attivitaForm";
		} else {
			if (!bindingResult.hasErrors()) {
				this.attivitaService.save(attivita);
				Centro centro = centroService.findById(idc);
				centro.addAttivita(attivita);
				this.centroService.save(centro);
				model.addAttribute("centro", centro);
				model.addAttribute("activities", centro.getAttivita());
				return "attivitaTable"; // return "allievoList";
			}
		}
		return "attivitaForm";
	}
	
	@RequestMapping("/centro/{idc}/attivita/{ida}/eliminaAttivita")
	public String eliminaAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, Model model,
			BindingResult bindingResult, @PathVariable("idc") Long idc) {
		Centro centro = centroService.findById(idc);
		centro.removeAttivita(attivita);
		model.addAttribute("centro", centro);
		model.addAttribute("attivita", centro.getAttivita());
		return "attivitaTable";
	}
}