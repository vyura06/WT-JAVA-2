package com.lab2.service.validation.impl;

import com.lab2.service.validation.Validator;

public class IntValidator implements Validator {
    @Override
    public boolean validate(Object obj) {
        return obj != null &&
                obj.getClass() == Integer.class &&
                ((Integer) obj).compareTo(0) > 0;
    }
}
