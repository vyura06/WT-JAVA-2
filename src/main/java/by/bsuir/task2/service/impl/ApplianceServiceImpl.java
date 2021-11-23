package by.bsuir.task2.service.impl;

import by.bsuir.task2.dao.DAOFactory;
import by.bsuir.task2.entity.Appliance;
import by.bsuir.task2.entity.criteria.Criteria;
import by.bsuir.task2.service.ApplianceService;
import by.bsuir.task2.service.validation.Validator;

import java.util.Arrays;

/**
 * Implementation of appliance service that works with
 * appliance dao impl
 */
public class ApplianceServiceImpl implements ApplianceService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance[] find(Criteria[] criteria) {
        if (!Arrays.stream(criteria).allMatch(Validator::criteriaValidator)) return null;

        return DAOFactory.getInstance().getApplianceDAO().find(criteria);
    }
}
