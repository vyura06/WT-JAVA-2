package com.lab2.entity.criteria;

public final class SearchCriteria {
    public static final String NAME = "NAME";

    public enum Common {
        COST
    }

    public enum Oven {
        POWER, WEIGHT
    }

    public enum Laptop {
        BATTERY, RAM, OS
    }

    public enum Teapot {
        MATERIAL, TYPE
    }

    private SearchCriteria() {
    }
}

