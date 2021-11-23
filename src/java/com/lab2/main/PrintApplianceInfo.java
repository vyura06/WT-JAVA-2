package com.lab2.main;

import com.lab2.entity.Appliance;

public class PrintApplianceInfo {

    public static void print(Appliance[] appliances) {
        if (appliances == null) {
            System.out.println("Find error");
        } else if (appliances.length == 0) {
            System.out.println("No appliances found");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance.toString());
            }
        }
    }
}
