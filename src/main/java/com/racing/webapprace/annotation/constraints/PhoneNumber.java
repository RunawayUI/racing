package com.racing.webapprace.annotation.constraints;

import com.racing.webapprace.validator.PhoneNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PhoneNumberConstraintValidator.class })
public @interface PhoneNumber {
    String message() default "PhoneNumber";

    Class<? extends Payload>[] payload() default { };
    Class<?>[] groups() default { };

    boolean withSpecSymbols() default true;
}