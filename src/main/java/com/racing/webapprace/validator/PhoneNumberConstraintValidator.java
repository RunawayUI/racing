package com.racing.webapprace.validator;

import com.racing.webapprace.annotation.constraints.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumber, String> {

    private boolean withSpecSymbols;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.withSpecSymbols = constraintAnnotation.withSpecSymbols();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }
        String validationTemplate = getValidationTemplate();
        for(int i = 0;i<value.length();i++) {
            char ch = value.charAt(i);
            if(validationTemplate.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    private static final String SPEC_SYMBOLS = "-+()";
    private static final String NUMBERS = "0123456789";

    private String getValidationTemplate() {
        StringBuilder template = new StringBuilder(NUMBERS);
        if(withSpecSymbols) {
            template.append(SPEC_SYMBOLS);
        }
        return template.toString();
    }
}