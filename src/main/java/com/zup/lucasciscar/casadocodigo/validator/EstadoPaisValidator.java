package com.zup.lucasciscar.casadocodigo.validator;

import com.zup.lucasciscar.casadocodigo.dto.request.PagamentoRequest;
import com.zup.lucasciscar.casadocodigo.entity.Estado;
import com.zup.lucasciscar.casadocodigo.entity.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return PagamentoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        PagamentoRequest request = (PagamentoRequest) o;
        Pais pais = entityManager.find(Pais.class, request.getIdPais());
        Estado estado = entityManager.find(Estado.class, request.getIdEstado());

        if(!estado.pertencePais(pais))
            errors.rejectValue("idEstado", null, "Estado não pertence ao País selecionado");
    }

}
