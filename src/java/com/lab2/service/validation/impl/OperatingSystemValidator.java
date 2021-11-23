package com.lab2.service.validation.impl;

import com.lab2.entity.OperatingSystem;
import com.lab2.service.validation.Validator;

public class OperatingSystemValidator implements Validator {
    @Override
    public boolean validate(Object obj) {
        try {
            OperatingSystem.valueOf((String) obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
