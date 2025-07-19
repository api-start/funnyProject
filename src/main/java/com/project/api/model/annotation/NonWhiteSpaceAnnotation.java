package com.project.api.model.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonWhiteSpaceAnnotation implements ConstraintValidator<NotNullNotWhitespace, String> {
    private final String WHITESPACE = " ";
    public NonWhiteSpaceAnnotation() {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.contains(WHITESPACE);
    }
}