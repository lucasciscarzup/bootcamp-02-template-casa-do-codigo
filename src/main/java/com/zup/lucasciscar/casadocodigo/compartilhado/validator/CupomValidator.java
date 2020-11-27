package com.zup.lucasciscar.casadocodigo.compartilhado.validator;

import com.zup.lucasciscar.casadocodigo.compra.CompraRequest;
import com.zup.lucasciscar.casadocodigo.cupom.Cupom;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Component
public class CupomValidator implements Validator {

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
        if(StringUtils.hasText(request.getCodigoCupom())) {
            Cupom cupom = entityManager.createQuery("from Cupom where codigo = :value", Cupom.class)
                    .setParameter("value", request.getCodigoCupom()).getSingleResult();

            if(!cupom.valido())
                errors.rejectValue("codigoCupom", null, "Cupom expirado");
        }
    }
}
