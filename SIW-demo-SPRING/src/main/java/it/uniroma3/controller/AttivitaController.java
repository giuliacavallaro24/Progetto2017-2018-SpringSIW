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

	@RequestMapping("/centro/{id}/activities")
	public String activitiesCentro(@PathVariable("id") Long id, Model model) {
		Centro centro = centroService.findById(id);
		model.addAttribute("centro",centro);
		model.addAttribute("activities", centro.getAttivita());
		return "attivitaTable";
	}

	@RequestMapping("/addAttivita")
	public String addAttivita(Model model) {
		model.addAttribute("attivita", new Attivita());
		return "attivitaForm";
	}

	@RequestMapping(value = "/attivita/{id}", method = RequestMethod.GET)
	public String getAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attivita", this.attivitaService.findById(id));
		return "showAttivita";
	}

	@RequestMapping("/centro/{id}/attivita")
	public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, Model model,
			BindingResult bindingResult, @PathVariable("id") Long id) {
		this.validator.validate(attivita, bindingResult);

		if (this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("exists", "Attivita gia' esistente");
			return "attivitaForm";
		} else {
			if (!bindingResult.hasErrors()) {
				this.attivitaService.save(attivita);
				Centro centro = centroService.findById(id);
				centro.addAttivita(attivita);
				model.addAttribute("centro", centro);
				model.addAttribute("activities", centro.getAttivita());
				return "attivitaTable"; // return "allievoList";
			}
		}
		return "attivitaForm";
	}
}