package by.bsuir.task2.main;

import by.bsuir.task2.entity.Appliance;
import by.bsuir.task2.entity.OperatingSystem;
import by.bsuir.task2.entity.criteria.Criteria;
import by.bsuir.task2.entity.criteria.SearchCriteria;
import by.bsuir.task2.entity.criteria.SearchCriteriaType;
import by.bsuir.task2.service.ApplianceService;
import by.bsuir.task2.service.ServiceFactory;

/**
 * Main class of a console program
 */
public class Main {

    /**
     * Main method
     * @param args console arguments
     */
    public static void main(String[] args) {
        ServiceFactory sf = ServiceFactory.getInstance();
        ApplianceService service = sf.getApplianceService();

        /*------------------------------------------------------------*/

        Criteria ovenCriteria = new Criteria(SearchCriteria.NAME, SearchCriteriaType.EQ.name(), "oven");
        Criteria[] criteria1 = new Criteria[]{ovenCriteria}; // find all ovens
        Appliance[] found1 = service.find(criteria1);

        System.out.println("All ovens:");
        PrintApplianceInfo.print(found1);
        System.out.println();

        /*------------------------------------------------------------*/

        Criteria costCriteria = new Criteria(SearchCriteria.Common.COST.name(), SearchCriteriaType.LT.name(), 200);
        Criteria[] criteria2 = new Criteria[]{costCriteria};
        Appliance[] found2 = service.find(criteria2); // cost < 200

        System.out.println("All appliances of cost less than 200:");
        PrintApplianceInfo.print(found2);
        System.out.println();

        /*------------------------------------------------------------*/

        Criteria laptopCriteria = new Criteria(SearchCriteria.NAME, SearchCriteriaType.EQ.name(), "laptop");
        Criteria batteryCriteria = new Criteria(SearchCriteria.Laptop.BATTERY.name(), SearchCriteriaType.GT.name(), 1500);
        Criteria costCriteria2 = new Criteria(SearchCriteria.Common.COST.name(), SearchCriteriaType.LT.name(), 1000);
        Criteria[] criteria3 = new Criteria[]{laptopCriteria, batteryCriteria, costCriteria2}; // laptop AND battery > 1500
        Appliance[] found3 = service.find(criteria3);

        System.out.println("All laptops of battery more than 1500 and cost < 100:");
        PrintApplianceInfo.print(found3);
        System.out.println();

        /*------------------------------------------------------------*/

        Criteria linuxCriteria = new Criteria(SearchCriteria.Laptop.OS.name(), SearchCriteriaType.EQ.name(), OperatingSystem.LINUX.name());
        Criteria[] criteria4 = new Criteria[]{laptopCriteria, batteryCriteria, costCriteria2, linuxCriteria}; // laptop AND battery > 1500
        Appliance[] found4 = service.find(criteria4);

        System.out.println("All laptops of battery more than 1500 and cost < 100:");
        PrintApplianceInfo.print(found4);
    }

}
