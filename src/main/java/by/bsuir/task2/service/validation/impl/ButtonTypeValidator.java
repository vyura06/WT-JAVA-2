package by.bsuir.task2.service.validation.impl;

import by.bsuir.task2.entity.ButtonType;
import by.bsuir.task2.service.validation.ValueValidator;

/**
 * Implements simple value validator for button type
 */
public class ButtonTypeValidator implements ValueValidator {
    /**
     * {@inheritDoc}
     */
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
