package com.lab2.service.validation;

import com.lab2.entity.criteria.Criteria;

public class Validators {

    public static boolean criteriaValidator(Criteria criteria) {
        if (criteria == null ||
                criteria.getSearchCriteria() == null ||
                criteria.getSearchType() == null ||
                criteria.getValue() == null) return false;

        CriteriaValidator validator = CriteriaValidatorFactory.getInstance().getValidator(criteria.getSearchCriteria());
        return validator.validate(criteria.getSearchType(), criteria.getValue());
    }
}