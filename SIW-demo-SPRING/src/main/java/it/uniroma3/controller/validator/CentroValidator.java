package it.uniroma3.controller.validator;

import javax.xml.validation.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import it.uniroma3.model.Centro;

@Component
public abstract class CentroValidator extends Validator {
	
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxCapienza", "required");
	}

	
	public boolean supports(Class<?> aClass) {
		return Centro.class.equals(aClass);
	}
}
