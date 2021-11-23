package com.lab2.service;

import com.lab2.entity.Appliance;
import com.lab2.entity.criteria.Criteria;

public interface ApplianceService {

    Appliance[] find(Criteria[] criteria);

}
