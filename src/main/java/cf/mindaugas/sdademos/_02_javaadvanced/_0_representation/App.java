package cf.mindaugas.sdademos._02_javaadvanced._0_representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void executeJustHardcodedValuesAndMethodsExample(){
        // representation no. 1 - just properties / variables not encapsulated into anything
        var name = "Jonas";
        var ageYears = 55;
        var totalJobExperienceYears = 32;
        var timeWorkedInCompanyYears = 15;

        var raiseStatus = totalJobExperienceYears > 30 && timeWorkedInCompanyYears > 10 ? "RAISE" : "NO RAISE";
        System.out.println(raiseStatus);
    }

    public static void executeEncapsulatingIntoCollectionOfObjectsExample(){
        // // representation no. 2 - we encapsulate data into groups of related pieces of information
        // Object[][] employees = {
        //         {"Jonas", 32, 15}, // jonas - totalJobExperienceYears , timeWorkedInCompanyYears
        //         {"Petras", 25, 12}, // petras - totalJobExperienceYears , timeWorkedInCompanyYears
        // };
        //
        // for (Object[] employee : employees)
        //     System.out.println(employee[0]);

        // could be maps also - we will learn about them latter
        List<HashMap<String, Integer[]>> employees = new ArrayList<>(){{
           new HashMap<String, Integer[]>() {{ put("Jonas", new Integer[]{ 32, 15}); }};
           new HashMap<String, Integer[]>() {{ put("Petras", new Integer[]{ 35, 12}); }};
        }};
    }

    public static void executeOOPExample(){
        // representation no. 3 - all the benefits - encap, inher, compos, polym, abstrc.
        @AllArgsConstructor
        @ToString
        @Getter
        class Employee {
            private String name;
            private int totalJobExperienceYears;
            private int timeWorkedInCompanyYears;
        }

        Employee[] employees = {
                new Employee("Jonas", 55, 25),
                new Employee("Petras", 55, 18),
        };

        for (Employee employee : employees) {
            System.out.println(employee.getName());

            // var raiseStatus = employee.totalJobExperienceYears > 30 && employee.timeWorkedInCompanyYears > 10
            //         ? "RAISE" : "NO RAISE";
        }
    }

    public static void main(String[] args) {
        executeJustHardcodedValuesAndMethodsExample();
        executeEncapsulatingIntoCollectionOfObjectsExample();
        executeOOPExample();
    }
}
