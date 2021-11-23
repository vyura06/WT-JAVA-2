package com.lab2.service.validation.impl;

import com.lab2.entity.Material;
import com.lab2.service.validation.Validator;

public class MaterialValidator implements Validator {
    @Override
    public boolean validate(Object obj) {
        try {
            Material.valueOf((String) obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
