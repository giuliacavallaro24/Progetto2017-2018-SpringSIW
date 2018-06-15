package it.uniroma3.controller.validator;

import javax.xml.validation.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import it.uniroma3.model.Attivita;

@Component
public abstract class AttivitaValidator extends Validator{
	
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataOra", "required");
	}

	public boolean supports(Class<?> aClass) {
		return Attivita.class.equals(aClass);
	}
}
