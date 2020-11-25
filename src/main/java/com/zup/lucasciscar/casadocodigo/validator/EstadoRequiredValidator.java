package com.zup.lucasciscar.casadocodigo.validator;

import com.zup.lucasciscar.casadocodigo.dto.request.CompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class EstadoRequiredValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return CompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        CompraRequest request = (CompraRequest) o;

        Query query = entityManager.createQuery("from Estado where pais_id = :value");
        query.setParameter("value", request.getIdPais());

        // Se tiver Estados cadastrados com o idPais e o idEstado da request for null
        if(!query.getResultList().isEmpty() && request.getIdEstado() == null)
            errors.rejectValue("idEstado", null, "Estado obrigatório para esse País");
    }
}