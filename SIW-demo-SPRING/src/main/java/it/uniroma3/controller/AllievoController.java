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

import it.uniroma3.controller.validator.AllievoValidator;
import it.uniroma3.model.Allievo;
import it.uniroma3.service.AllievoService;

@Controller
public class AllievoController {
	
    @Autowired
    private AllievoService allievoService;

    @Autowired
    private AllievoValidator validator;

    @RequestMapping(value="/loginForm")
    public String termineLogin(Model model,@PathVariable("username") String username, @PathVariable("password") String password){
        boolean isValidUser = true; //AllievoService.validateUser(username, password);

        if (!isValidUser) {
            model.addAttribute("errorMessage", "Invalid Credentials");
            return "login.jsp";
        }
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "allievoForm";
    }
    
    @RequestMapping("/allievi")
    public String allievi(Model model) {
        model.addAttribute("allievi", this.allievoService.findAll());
        return "allievoTable";	// return "allievoList";
    }

    @RequestMapping("/addAllievo")
    public String addAllievo(Model model) {
        model.addAttribute("allievo", new Allievo());
        return "allievoForm";
    }

    @RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
    public String getAllievo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("allievo", this.allievoService.findById(id));
    	return "showAllievo";
    }

    @RequestMapping(value = "/allievo", method = RequestMethod.POST)
    public String newAllievo(@Valid @ModelAttribute("allievo") Allievo allievo, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(allievo, bindingResult);
        
        if (this.allievoService.alreadyExists(allievo)) {
            model.addAttribute("exists", "Allievo gi� esistente");
            return "allievoForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.allievoService.save(allievo);
                model.addAttribute("allievi", this.allievoService.findAll());
                return "allievoTable"; //return "allievoList";
            }
        }
        return "allievoForm";
    }

}
