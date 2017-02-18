package com.yangyang.convertor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.Temporal;

public class PastValidator implements ConstraintValidator<Past, Temporal> {
    @Override
    public void initialize(Past past) {

    }

    @Override
    public boolean isValid(Temporal value, ConstraintValidatorContext context) {
        if(value == null) return true;
        return LocalDate.from(value).isBefore(LocalDate.now());
    }
}
