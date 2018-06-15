package it.uniroma3.controller.validator;

import it.uniroma3.model.Allievo;

@Component
public class AttivitaValidator extends Validator{
	
	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataOra", "required");
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Attivita.class.equals(aClass);
	}
}


}
