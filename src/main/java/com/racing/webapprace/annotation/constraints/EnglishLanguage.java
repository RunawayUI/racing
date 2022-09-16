package com.racing.webapprace.annotation.constraints;

import com.racing.webapprace.validator.EnglishLanguageConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { EnglishLanguageConstraintValidator.class })
public @interface EnglishLanguage {
    String message() default "EnglishLanguage";
    boolean withNumbers() default true;
    boolean withPunctuations() default true;
    boolean withSpecSymbols() default true;
    Class<? extends Payload>[] payload() default { };
    Class<?>[] groups() default { };
}