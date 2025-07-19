package com.project.api.model.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= NonWhiteSpaceAnnotation.class)
public @interface NotNullNotWhitespace {
    String message() default "string cannot contain whitespaces";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
