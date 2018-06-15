package it.uniroma3.controller.validator;

import org.graalvm.compiler.lir.CompositeValue.Component;

import com.sun.tools.javac.resources.CompilerProperties.Errors;

import it.uniroma3.model.Centro;

@Component
public class CentroValidator extends Validator {
	
	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxCapienza", "required");
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Centro.class.equals(aClass);
	}
}


}
