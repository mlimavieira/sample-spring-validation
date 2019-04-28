package com.mlimavieira.samplespringvalidation.service.validators;


import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BeerTypeValidation implements ConstraintValidator<BeerType, String> {

    private String[] types = {"LAGER", "IPA", "ALE", "STOUT"};

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(value)) {
            return false;
        }

        for (String type: types ) {
            if(type.equals(value)) {
                return true;
            }
        }

        return false;
    }

}
