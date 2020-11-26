package com.zup.lucasciscar.casadocodigo.compartilhado.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "Campo já existe no sistema";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldName();
    Class<?> domainClass();

}
