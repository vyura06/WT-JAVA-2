package by.bsuir.task2.dao.creator.impl;

import by.bsuir.task2.dao.creator.ApplianceCreator;
import by.bsuir.task2.entity.Appliance;
import by.bsuir.task2.entity.Laptop;
import by.bsuir.task2.entity.OperatingSystem;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents creator of a laptop appliance
 */
public class LaptopCreator extends ApplianceCreator {

    private static final String BATTERY_NAME = "battery";
    private static final String RAM_NAME = "ram";
    private static final String OS_NAME = "os";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(NodeList nodes) {
        int cost = 0;
        int battery = 0;
        int ram = 0;
        OperatingSystem os = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case COST_NAME -> cost = Integer.parseInt(text);
                    case BATTERY_NAME -> battery = Integer.parseInt(text);
                    case RAM_NAME -> ram = Integer.parseInt(text);
                    case OS_NAME -> os = OperatingSystem.valueOf(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }

        if (cost == 0 || battery == 0 || ram == 0 || os == null) {
            throw new IllegalArgumentException("Not enough fields in appliance");
        }

        return new Laptop(cost, battery, ram, os);
    }
}
