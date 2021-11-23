package com.lab2.service.validation.impl;

import com.lab2.service.validation.CriteriaValidator;
import com.lab2.service.validation.Validator;

import java.util.Arrays;

public class CriteriaValidatorImpl implements CriteriaValidator {
    private final String[] allowedTypes;
    private final Validator validator;

    public static CriteriaValidator create(Validator validator, String... allowedTypes) {
        return new CriteriaValidatorImpl(allowedTypes, validator);
    }

    public CriteriaValidatorImpl(String[] allowedTypes, Validator validator) {
        this.allowedTypes = allowedTypes;
        this.validator = validator;
    }

    @Override
    public boolean validate(String searchType, Object value) {
        return Arrays.asList(allowedTypes).contains(searchType) && validator.validate(value);
    }
}
