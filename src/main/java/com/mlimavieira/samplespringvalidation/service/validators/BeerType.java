package com.mlimavieira.samplespringvalidation.service.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BeerTypeValidation.class)
@Documented
public @interface BeerType {


    String message() default "Beer Type required";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
