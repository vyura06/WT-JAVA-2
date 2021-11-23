package com.lab2.dao.creator;

import com.lab2.entity.Appliance;
import org.w3c.dom.NodeList;

public abstract class ApplianceCreator {
    protected static final String COST_NAME = "cost";

    public abstract Appliance create(NodeList nodes);
}
