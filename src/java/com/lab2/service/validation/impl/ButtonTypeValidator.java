package com.lab2.service.validation.impl;

import com.lab2.entity.ButtonType;
import com.lab2.service.validation.Validator;

public class ButtonTypeValidator implements Validator {
    @Override
    public boolean validate(Object obj) {
        try {
            ButtonType.valueOf((String) obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
