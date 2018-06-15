package it.uniroma3.controller;

import it.uniroma3.controller.validator.CentroValidator;
import it.uniroma3.model.Centro;
import it.uniroma3.service.CentroService;

public class CentroController {
	
	@Autowired
    private CentroService centroService;

    @Autowired
    private CentroValidator validator;

    
    @RequestMapping("/centri")
    public String centri(Model model) {
        model.addAttribute("centri", this.centroService.findAll());
        return "centroTable";	// return "allievoList";
    }

    @RequestMapping("/addCentro")
    public String addCentro(Model model) {
        model.addAttribute("centro", new Centro());
        return "centroForm";
    }

    @RequestMapping(value = "/centro/{id}", method = RequestMethod.GET)
    public String getCentro(@PathVariable("id") Long id, Model model) {
        model.addAttribute("centro", this.centroService.findById(id));
    	return "showCentro";
    }

    @RequestMapping(value = "/centro", method = RequestMethod.POST)
    public String newCentro(@Valid @ModelAttribute("centro") Centro centro, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(centro, bindingResult);
        
        if (this.centroService.alreadyExists(centro)) {
            model.addAttribute("exists", "Centro già esistente");
            return "centroForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.centroService.save(centro);
                model.addAttribute("centri", this.centroService.findAll());
                return "centroTable"; //return "allievoList";
            }
        }
        return "centroForm";
    }

}
