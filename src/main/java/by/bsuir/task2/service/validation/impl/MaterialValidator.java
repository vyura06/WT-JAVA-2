package by.bsuir.task2.service.validation.impl;

import by.bsuir.task2.entity.Material;
import by.bsuir.task2.service.validation.ValueValidator;

/**
 * Simple material validator
 */
public class MaterialValidator implements ValueValidator {
    /**
     * {@inheritDoc}
     */
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
