package com.estore.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstName;
    private String secondName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstName = constraintAnnotation.first();
        secondName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;
        try {
            Object firstObject = new BeanWrapperImpl(o).getPropertyValue(firstName);
            Object secondObject = new BeanWrapperImpl(o).getPropertyValue(secondName);
            valid = firstObject == null && secondObject == null
                    || firstObject != null && firstObject.equals(secondObject);
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (!valid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
