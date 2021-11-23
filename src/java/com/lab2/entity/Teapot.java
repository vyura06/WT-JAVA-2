package com.lab2.entity;

import com.lab2.entity.criteria.Criteria;
import com.lab2.entity.criteria.SearchCriteria;

public class Teapot extends Appliance {
    private static final String MATERIAL_CRITERIA = "MATERIAL";
    private static final String TYPE_CRITERIA = "TYPE";
    private static final String TEAPOT_NAME = "teapot";

    private final Material material;
    private final ButtonType type;

    public Material getMaterial() {
        return material;
    }

    public ButtonType getType() {
        return type;
    }

    public Teapot(int cost, Material material, ButtonType type) {
        super(cost);
        this.material = material;
        this.type = type;
    }

    @Override
    public boolean matches(Criteria criteria) {
        if (super.matches(criteria)) return true;

        return switch (criteria.getSearchCriteria()) {
            case SearchCriteria.NAME -> TEAPOT_NAME.equals(criteria.getValue());
            case MATERIAL_CRITERIA -> material == Material.valueOf((String) criteria.getValue());
            case TYPE_CRITERIA -> type == ButtonType.valueOf((String) criteria.getValue());
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "Teapot{" +
                "cost=" + cost +
                ", material=" + material +
                ", type=" + type +
                '}';
    }
}
