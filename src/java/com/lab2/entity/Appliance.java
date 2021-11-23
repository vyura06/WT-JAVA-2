package com.lab2.entity;

import com.lab2.entity.criteria.Criteria;
import com.lab2.entity.criteria.SearchCriteria;
import com.lab2.entity.criteria.SearchCriteriaType;

public class Appliance {
    protected final int cost;

    public int getCost() {
        return cost;
    }

    public Appliance(int cost) {
        this.cost = cost;
    }

    public boolean matches(Criteria criteria) {
        if (!criteria.getSearchCriteria().equals(SearchCriteria.Common.COST.name())) return false;

        return switch (SearchCriteriaType.valueOf(criteria.getSearchType())) {
            case LT -> cost < (Integer) criteria.getValue();
            case GT -> cost > (Integer) criteria.getValue();
            case EQ -> cost == (Integer) criteria.getValue();
        };
    }
}