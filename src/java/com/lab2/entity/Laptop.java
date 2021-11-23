package com.lab2.entity;

import com.lab2.entity.criteria.Criteria;
import com.lab2.entity.criteria.SearchCriteria;
import com.lab2.entity.criteria.SearchCriteriaType;

public class Laptop extends Appliance {
    private static final String BATTERY_CRITERIA = "BATTERY";
    private static final String RAM_CRITERIA = "RAM";
    private static final String OS_CRITERIA = "OS";
    private static final String LAPTOP_NAME = "laptop";

    private final int battery;
    private final int ram;
    private final OperatingSystem os;

    public int getBattery() {
        return battery;
    }

    public int getRam() {
        return ram;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public Laptop(int cost, int battery, int ram, OperatingSystem os) {
        super(cost);
        this.battery = battery;
        this.ram = ram;
        this.os = os;
    }

    @Override
    public boolean matches(Criteria criteria) {
        if (super.matches(criteria)) return true;

        int value;
        switch (criteria.getSearchCriteria()) {
            case SearchCriteria.NAME:
                return LAPTOP_NAME.equals(criteria.getValue());
            case BATTERY_CRITERIA:
                value = battery;
                break;
            case RAM_CRITERIA:
                value = ram;
                break;
            case OS_CRITERIA:
                return os == OperatingSystem.valueOf((String) criteria.getValue());
            default:
                return false;
        }

        return switch (SearchCriteriaType.valueOf(criteria.getSearchType())) {
            case LT -> value < (Integer) criteria.getValue();
            case GT -> value > (Integer) criteria.getValue();
            case EQ -> value == (Integer) criteria.getValue();
        };
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cost=" + cost +
                ", battery=" + battery +
                ", ram=" + ram +
                ", os=" + os +
                '}';
    }
}
