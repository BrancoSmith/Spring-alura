package br.com.loja.validation;

import org.springframework.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.loja.models.Produto;

public class ProdutoValidation implements Validator{

	// validadção para a classe produto
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}
	
	public void validate( Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo",  "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao",  "field.required");
		
		
		Produto produto = (Produto) target;
		
		if(produto.getPaginas() <= 0 ) {
			errors.rejectValue("paginas", "field.required");
		}
		
	}
	

}
