package it.uniroma3.controller;

import it.uniroma3.model.Attivita;
import it.uniroma3.service.AttivitaService;

public class AttivitaController {

	@Autowired
    private AttivitaService attivitaService;

    @Autowired
    private AttivitaValidator validator;

    
    @RequestMapping("/activities")
    public String activities(Model model) {
        model.addAttribute("centri", this.attivitaService.findAll());
        return "attivitaTable";	// return "allievoList";
    }

    @RequestMapping("/addAttivita")
    public String addCentro(Model model) {
        model.addAttribute("attivita", new Attivita());
        return "attivitaForm";
    }

    @RequestMapping(value = "/attivita/{id}", method = RequestMethod.GET)
    public String getAttivita(@PathVariable("id") Long id, Model model) {
        model.addAttribute("attivita", this.attivitaService.findById(id));
    	return "showAttivita";
    }

    @RequestMapping(value = "/attivita", method = RequestMethod.POST)
    public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(attivita, bindingResult);
        
        if (this.attivitaService.alreadyExists(attivita)) {
            model.addAttribute("exists", "Attivita già esistente");
            return "attivitaForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.attivitaService.save(attivita);
                model.addAttribute("activities", this.attivitaService.findAll());
                return "attivitaTable"; //return "allievoList";
            }
        }
        return "attivitaForm";
    }

}