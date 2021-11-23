package by.bsuir.task2.dao.creator.impl;

import by.bsuir.task2.dao.creator.ApplianceCreator;
import by.bsuir.task2.entity.Appliance;
import by.bsuir.task2.entity.ButtonType;
import by.bsuir.task2.entity.Material;
import by.bsuir.task2.entity.Teapot;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Creator of a teapot appliance
 */
public class TeapotCreator extends ApplianceCreator {
    private static final String MATERIAL_NAME = "material";
    private static final String TYPE_NAME = "type";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(NodeList nodes) {
        int cost = 0;
        Material material = null;
        ButtonType type = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case COST_NAME -> cost = Integer.parseInt(text);
                    case MATERIAL_NAME -> material = Material.valueOf(text);
                    case TYPE_NAME -> type = ButtonType.valueOf(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }

        if (cost == 0 || material == null || type == null) {
            throw new IllegalArgumentException("Not enough fields in appliance");
        }

        return new Teapot(cost, material, type);
    }
}
