package com.lab2.service.impl;

import com.lab2.dao.DAOFactory;
import com.lab2.entity.Appliance;
import com.lab2.entity.criteria.Criteria;
import com.lab2.service.ApplianceService;
import com.lab2.service.validation.Validators;

import java.util.Arrays;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public Appliance[] find(Criteria[] criteria) {
        for (Criteria criterion : criteria) {
            if (!Validators.criteriaValidator(criterion)) {
                return null;
            }
        }

        return DAOFactory.getInstance().getApplianceDAO().find(criteria);
    }
}
