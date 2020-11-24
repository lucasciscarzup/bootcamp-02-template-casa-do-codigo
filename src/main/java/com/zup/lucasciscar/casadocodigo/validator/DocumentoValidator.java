package com.zup.lucasciscar.casadocodigo.validator;

import com.zup.lucasciscar.casadocodigo.dto.request.PagamentoRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DocumentoValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return PagamentoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        PagamentoRequest request = (PagamentoRequest) o;
        if(!request.documentoValido())
            errors.rejectValue("documento", null, "CPF/CNPJ inválido");
    }
}
