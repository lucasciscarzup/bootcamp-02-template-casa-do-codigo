package com.zup.lucasciscar.casadocodigo.compartilhado.validator;

import com.zup.lucasciscar.casadocodigo.compra.CompraRequest;
import com.zup.lucasciscar.casadocodigo.localidade.Estado;
import com.zup.lucasciscar.casadocodigo.localidade.Pais;
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
        return CompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        CompraRequest request = (CompraRequest) o;

        if(request.getIdEstado() != null) {
            Pais pais = entityManager.find(Pais.class, request.getIdPais());
            Estado estado = entityManager.find(Estado.class, request.getIdEstado());

            if(!estado.pertencePais(pais))
                errors.rejectValue("idEstado", null, "Estado não pertence ao País selecionado");
        }
    }

}
