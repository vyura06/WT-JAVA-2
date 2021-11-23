package com.lab2.dao.creator;

import com.lab2.dao.creator.impl.LaptopCreator;
import com.lab2.dao.creator.impl.OvenCreator;
import com.lab2.dao.creator.impl.TeapotCreator;

public class ApplianceCreatorFactory {
    private static final ApplianceCreatorFactory instance = new ApplianceCreatorFactory();

    private ApplianceCreatorFactory() {

    }

    public static ApplianceCreatorFactory getInstance() {
        return instance;
    }

    public ApplianceCreator getCreator(String applianceName) {
        return switch (applianceName) {
            case "oven" -> new OvenCreator();
            case "laptop" -> new LaptopCreator();
            case "teapot" -> new TeapotCreator();
            default -> throw new IllegalArgumentException("No such appliance creator exists");
        };
    }
}
