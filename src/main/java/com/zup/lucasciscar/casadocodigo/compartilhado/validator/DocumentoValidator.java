package com.zup.lucasciscar.casadocodigo.compartilhado.validator;

import com.zup.lucasciscar.casadocodigo.compra.CompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DocumentoValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return CompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        CompraRequest request = (CompraRequest) o;
        if(!request.documentoValido())
            errors.rejectValue("documento", null, "CPF/CNPJ inválido");
    }
}
