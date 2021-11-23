package com.lab2.dao;

import com.lab2.entity.Appliance;
import com.lab2.entity.criteria.Criteria;


public interface ApplianceDAO {

    Appliance[] find(Criteria[] criteria);
}
