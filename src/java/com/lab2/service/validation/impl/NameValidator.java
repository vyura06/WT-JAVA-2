package com.lab2.service.validation.impl;

import com.lab2.service.validation.Validator;

public class NameValidator implements Validator {
    @Override
    public boolean validate(Object obj) {
        return obj != null && obj.getClass() == String.class;
    }
}
