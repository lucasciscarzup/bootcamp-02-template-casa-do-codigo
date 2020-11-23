package com.zup.lucasciscar.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {

    String message() default "Não há informações cadastradas com esse Id no sistema";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();

}
